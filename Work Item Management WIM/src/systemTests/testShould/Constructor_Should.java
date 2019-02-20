package systemTests.testShould;

import org.junit.Test;
import system.wim.models.contracts.*;
import system.wim.models.enums.*;
import system.wim.models.modelsImpl.*;


public class Constructor_Should {
    Member member = new MemberImpl("Martin");


    @Test(expected = IllegalArgumentException.class)
    public void throwWhenDescriptionIsNotInRange() {
        // Arrange, Act, Assert
        Bug bug = new BugImpl("TitleOne 1 ", "desc", "one, two", Priority.HIGH, member, BugSeverity.CRITICAL, BugStatus.ACTIVE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenTitleIsNull() {
        // Arrange, Act, Assert
        Bug bug = new BugImpl(null, "description", "one, two", Priority.HIGH, member, BugSeverity.CRITICAL, BugStatus.ACTIVE);

    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenStepToReproduceIsNull() {
        // Arrange, Act, Assert
        Bug bug = new BugImpl("TitleOne 1 ", "description", null, Priority.HIGH, member, BugSeverity.CRITICAL, BugStatus.ACTIVE);

    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenTheTitleIsSmallerThanMinValue() {
        // Arrange, Act, Assert
        Bug bug = new BugImpl("T", "description", "one, two", Priority.HIGH, member, BugSeverity.CRITICAL, BugStatus.ACTIVE);

    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenTheTitleIsBiggerThanMaxValue() {
        // Arrange, Act, Assert
        Bug bug = new BugImpl("TitleOne with symbols that are  more than max value ", "description", "one, two", Priority.HIGH, member, BugSeverity.CRITICAL, BugStatus.ACTIVE);

    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenMemberAssigneeIsNull() {
        // Arrange, Act, Assert
        Story story = new StoryImpl("TitleOfStory1", "Description 1 ", Priority.HIGH, null, StorySize.LARGE, StoryStatus.DONE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenTitleOfStoryInNotInRange() {
        // Arrange, Act, Assert
        Story story = new StoryImpl("T", "Description 1 ", Priority.HIGH, member, StorySize.LARGE, StoryStatus.DONE);

    }

    @Test
    public void createStoryWhenValidValuesArePassed() {
        // Arrange, Act, Assert
        Story story = new StoryImpl("TitleOfStory1", "Description 1 ", Priority.HIGH, member, StorySize.LARGE, StoryStatus.DONE);

    }

    @Test
    public void createBugWhenValidValuesArePassed() {
        // Arrange, Act, Assert
        Bug bug = new BugImpl("TitleOne 1 ", "description", "One, TWO", Priority.HIGH, member, BugSeverity.CRITICAL, BugStatus.ACTIVE);

    }

    @Test
    public void createFeedbackWhenValidValuesArePassed() {
        // Arrange, Act, Assert
        Feedback feedback = new FeedbackImpl("TitleOne 1 ", "description", 5, FeedBackStatus.NEW);

    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenTitleOfFeedbackInNotInRange() {
        // Arrange, Act, Assert
        Feedback feedback = new FeedbackImpl("T", "description", 5, FeedBackStatus.NEW);

    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenTitleOfFeedbackIsNull() {
        // Arrange, Act, Assert
        Feedback feedback = new FeedbackImpl(null, "description", 5, FeedBackStatus.NEW);

    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenDescriptionOfFeedbackIsNull() {
        // Arrange, Act, Assert
        Feedback feedback = new FeedbackImpl("title of fb", null, 5, FeedBackStatus.NEW);

    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenDescriptionOfFeedbackInNotInRange() {
        // Arrange, Act, Assert
        Feedback feedback = new FeedbackImpl("TitleOfFeedbackOne", "desc", 5, FeedBackStatus.NEW);

    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenRatingOfFeedbackInNotInRange() {
        // Arrange, Act, Assert
        Feedback feedback = new FeedbackImpl("TitleOfFeedbackOne", "description one ", -4, FeedBackStatus.NEW);

    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenBoardNameIsNull() {
        // Arrange, Act, Assert
        Board board = new BoardImpl(null);

    }

    @Test
    public void createBoardWhenValidValuesArePassed() {
        // Arrange, Act, Assert
        Board board = new BoardImpl("Board name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCreateNewPersonWithNullValue() {
        Member member1 = new MemberImpl(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCreateNewPersonWhenNameIsLessThanMinLength() {
        Member member2 = new MemberImpl("m");
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCreateNewPersonWhenNameIsBiggerThanMaxLength() {
        Member member2 = new MemberImpl("name with more symbols than it should be ");
    }

    @Test
    public void createNewPersonWhenValidValuesArePassed() {
        Member memberTest = new MemberImpl("Martin");
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCreatingBugWithNullStepsToReproduce() {
        Bug bug = new BugImpl("title of bug", "description of Bug", null, Priority.HIGH, member, BugSeverity.CRITICAL, BugStatus.ACTIVE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCreatingCommentWithNullValueForAuthor() {
        Comment comment = new CommentImpl(null, "str msg");
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCreatingCommentWithNullValueForMessage() {
        Comment comment = new CommentImpl("author name", null);
    }

    @Test
    public void createNewCommentWhenDataIsValid() {
        Comment comment = new CommentImpl("AUTHOR NAME", "MESSAGE");
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCreatingHistoryWithNullValueForProperty() {
        History comment = new HistoryImpl(null, "oldValue", "newValue");
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCreatingHistoryWithNullValueForOldValue() {
        History comment = new HistoryImpl("Property", null, "newValue");
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCreatingHistoryWithNullValueForNewValue() {
        History comment = new HistoryImpl("Property", "OldValue", null);
    }

    @Test
    public void createNewHistoryWhenParametersAreValid() {
        History comment = new HistoryImpl("Property", "oldValue", "newValue");
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCreatingTaskWithNullValueForTitle() {
        Task task = new TaskImpl(null, "description ", Priority.HIGH, member);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCreatingTaskWithNullValueForDescription() {
        Task task = new TaskImpl("title of task", null, Priority.HIGH, member);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsWhenCreatingTaskWithNullValueForMember() {
        Task task = new TaskImpl("title of task", "description ", Priority.HIGH, null);
    }

    @Test
    public void createNewTaskWhenParametersAreValid() {
        Task task = new TaskImpl("title of task", "description ", Priority.HIGH, member);

    }
//   @Test(expected = IllegalArgumentException.class)
//   public void throwWhenNullIngredientsArePassed() {
//       // Arrange, Act, Assert
//       ToothpasteImpl shampoo = new ToothpasteImpl("name", "brand", 10, GenderType.Women, null);
//   }

//   @Test
//   public void createToothpasteWhenValidValuesArePassed() {
//       // Arrange, Act, Assert
//       ToothpasteImpl shampoo = new ToothpasteImpl("name", "brand", 10, GenderType.Women, "ingredients");
//   }
}

