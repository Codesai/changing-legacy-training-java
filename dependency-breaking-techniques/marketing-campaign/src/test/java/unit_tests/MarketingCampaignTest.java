package unit_tests;

import marketing_campaign.MarketingCampaign;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MarketingCampaignTest {
    @Test
    public void would_it_ever_pass()
    {
        var campaign = new MarketingCampaign();

        var isCrazySalesDay = campaign.isCrazySalesDay();

        assertThat(isCrazySalesDay, is(true));
    }

    @Test
    public void fix_me_and_rename_me()
    {
        var campaign = new MarketingCampaign();

        var isActive = campaign.isActive();

        assertThat(isActive, is(true));
    }
}

