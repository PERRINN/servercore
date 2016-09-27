package com.perrinn.appservice.team;

import java.util.Random;

import org.junit.Test;
import org.junit.Assert;

public class TeamTest {
	@Test
	public void testId() {
		Team t = new Team();
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
	public void testTeamOwner() {
		Team t = new Team();
		Random r = new Random();
		int p = 0;
		while (p < 1000) {
			long l = r.nextLong();
			t.setTeamOwner(l);
			Assert.assertEquals(l, t.getTeamOwner());
			p++;
		}
	}

	@Test
	public void testTeamName() {
		Team t = new Team();
		Random r = new Random();
		int p = 0;
		while (p < 1000) {
			long l = r.nextLong();
			t.setTeamName(String.valueOf(l));
			Assert.assertEquals(String.valueOf(l), t.getTeamName());
			p++;
		}
	}
}
