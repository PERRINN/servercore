package com.perrinn.appservice.dao;

import java.util.List;
import com.perrinn.appservice.geo.Country;

public interface CountryDAO {
	public void save(Country c);
	public List<Country> list();
}