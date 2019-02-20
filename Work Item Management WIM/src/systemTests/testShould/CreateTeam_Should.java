package systemTests.testShould;

import org.junit.Assert;
import org.junit.Test;
import system.wim.engine.factory.WorkItemFactoryImpl;
import system.wim.models.contracts.Team;

public class CreateTeam_Should {
    @Test
    public void returnInstanceOfTypeTeam() {
        WorkItemFactoryImpl workItemFactory = new WorkItemFactoryImpl();
        Team team = workItemFactory.createTeam("TeamName");
        Assert.assertTrue(team instanceof Team);
    }
}
