package exe.demo.controllers;

import exe.demo.models.Course;
import exe.demo.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private List<Student> studentList = new ArrayList<>();
    private Map<Integer, List<Course>> studentCourses = new HashMap<>();

    public StudentController() {
        studentList.add(new Student(0, "Petar", "Petrov"));
        studentList.add(new Student(1, "Ivan", "Ivanov"));
        studentList.add(new Student(2, "JORO", "KOLOL"));

        studentCourses.put(0,new ArrayList<>());
        studentCourses.get(0).add(new Course("java", 5000, "programming"));
        studentCourses.put(1,new ArrayList<>());
        studentCourses.get(1).add(new Course("pitona", 10001000, "AI"));
        studentCourses.put(2,new ArrayList<>());
        studentCourses.get(2).add(new Course("c#", 2000, "neshto"));
    }



    @PostMapping("/new")
    public void addStudent(@RequestBody Student student) {
        studentList.add(student);
    }

    @GetMapping("/course/{id}")
    public List<Course> getCourses(@PathVariable int id){
       return studentCourses.get(id);
    }

    @PostMapping("/new/course/{id}")
    public void addCourse(@RequestBody Course course, @PathVariable int id) {

        if (studentCourses.containsKey(id)) {
            studentCourses.get(id).add(course);
        } else {
            Student s = studentList.stream().filter(x -> x.getId() == id).findFirst().orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                            String.format("Student with id %d was not found!", id))
            );
            studentCourses.put(s.getId(), new ArrayList<>());
            studentCourses.get(s.getId()).add(course);

        }
    }

    @GetMapping
    public List<Student> getStudentList() {
        return studentList;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentList.stream().filter(x -> x.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Student with id %d cannot be found!", id)
                ));
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestBody Student student) {
        studentList.remove(student.getId());
        return String.format("Student with id %d was removed!", student.getId());
    }

    @PutMapping("/course/replace/{id}")
    public void replaceCourse(@RequestBody Course course,@PathVariable int id){
       Course c = studentCourses.get(id).stream().filter(x->x.getCourse().equals(course.getCourse()))
                .findFirst().orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format(
                                "Course with name '%s' was not found!",course.getCourse()
                        )
                )
        );

       studentCourses.get(id).remove(c);
       studentCourses.get(id).add(course);


    }

    @PutMapping("/replace")
    //try with query param and @PathVariable
    public void replaceStudent(@RequestBody Student student) {

        // studentList.get(student.getId()).setFirstName(student.getFirstName());
        studentList.remove(student.getId() - 1);
        studentList.add(student.getId() - 1, student);
    }
}
