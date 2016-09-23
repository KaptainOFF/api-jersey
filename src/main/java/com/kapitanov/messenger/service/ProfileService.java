package com.kapitanov.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kapitanov.messenger.database.Database;
import com.kapitanov.messenger.model.Profile;

public class ProfileService {
	
	private static Map<String, Profile> profiles = Database.getProfiles(); 
	
	public ProfileService() {
		profiles.put("dooo",new Profile(1L,"Yaba","Daba,","dooo"));
	}
	
	public List<Profile> getAllProfiles() {
		List<Profile> result = new ArrayList<>();
		for (String key : profiles.keySet()) {
			result.add(profiles.get(key));
		}
		return result;
	}
	
	public Profile getProfile(String name) {
		return profiles.get(name);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getId() <= 0) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(Profile profile) {
		return profiles.remove(profile);
	}
}
