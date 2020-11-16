package Dao;

import Model.Ad;

import java.util.ArrayList;
import java.util.List;

public class ListAdsDao implements Ads {
	private List<Ad> ads;

	public List<Ad> all() {
		if (ads == null) {
			ads = generateAds();
		}
		return ads;
	}

	public Long insert(Ad ad) {
		if (ads == null) {
			ads = generateAds();
		}
		ad.setId((long) ads.size());
		ads.add(ad);
		return ad.getId();
	}

	private List<Ad> generateAds() {
		List<Ad> ads = new ArrayList<>();
		return ads;
	}
}