package unit_tests;

import marketing_campaign.MarketingCampaign;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MarketingCampaignTest {
    @Test
    public void would_it_ever_pass()
    {
        var campaign = new MarketingCampaign();

        var isCrazySalesDay = campaign.isCrazySalesDay();

        assertThat(isCrazySalesDay).isEqualTo(true);
    }

    @Test
    public void fix_me_and_rename_me()
    {
        var campaign = new MarketingCampaign();

        var isActive = campaign.isActive();

        assertThat(isActive).isEqualTo(true);
    }
}

