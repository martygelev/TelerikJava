import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


 class SubdomainVisitCount
{
    public static List<String> subdomainVisits(String[] cpdomains)
    {
        Map<String, Integer> occurrences = new HashMap<>();

        for (String domain : cpdomains)
        {
            String[] splitted = domain.split("\\s");

            List<String> domains = new ArrayList<>();

            domains.add(splitted[1]);
            domains.add(domains.get(0).substring(domains.get(0).indexOf('.') + 1));
            if (domains.get(1).contains("."))
                domains.add(domains.get(1).substring(domains.get(1).indexOf('.') + 1));

            int visits = Integer.parseInt(splitted[0]);
            for (String dom : domains)
            {
                if (!occurrences.containsKey(dom))
                    occurrences.put(dom, visits);
                else
                    occurrences.put(dom, occurrences.get(dom) + visits);
            }
        }

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : occurrences.entrySet())
            result.add(entry.getValue() + " " + entry.getKey());

        return result;
    }

    public static void main(String[] args)
    {
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

        List<String> subdomainVisitCount = subdomainVisits(cpdomains);

        subdomainVisitCount.forEach(System.out::println);
    }
}