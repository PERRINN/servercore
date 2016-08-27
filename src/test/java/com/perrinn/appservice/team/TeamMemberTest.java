package com.perrinn.appservice.team;

import java.util.Random;
import org.junit.Test;
import org.junit.Assert;

public class TeamMemberTest {
	@Test
	public void testId() {
		TeamMember t = new TeamMember();
		Random r = new Random();
		int p = 0;
		while (p < 1000) {
			long l = r.nextLong();
			t.setId(l);
			Assert.assertEquals(l, t.getId());
			p++;
		}
	}

	@Test
	public void testTeam() {
		TeamMember t = new TeamMember();
		Random r = new Random();
		int p = 0;
		while (p < 1000) {
			long l = r.nextLong();
			t.setTeam(l);
			Assert.assertEquals(l, t.getTeam());
			p++;
		}
	}

	@Test
	public void testTeamMember() {
		TeamMember t = new TeamMember();
		Random r = new Random();
		int p = 0;
		while (p < 1000) {
			long l = r.nextLong();
			t.setTeamMember(l);
			Assert.assertEquals(l, t.getTeamMember());
			p++;
		}
	}
}
