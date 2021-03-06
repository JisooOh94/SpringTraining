package bo;

import static cache.type.LocalCacheTopic.*;

import cache.CacheKey;
import cache.LocalCacheable;
import dao.UserInfoDao;
import model.UserInfo;

public class UserInfoBo {
	private final UserInfoDao userInfoDao;

	public UserInfoBo(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@LocalCacheable(topic = USER_INFO_CACHE, maxSize = 10, keyFormat = "userName_{}")
	public String getUserName(String userId) {
		return userInfoDao.getUserName(userId);
	}

	@LocalCacheable(topic = USER_INFO_CACHE, maxSize = 10, keyFormat = "userAge_{}")
	public int getUserAge(String userId) {
		return userInfoDao.getUserAge(userId);
	}

	public int getUserNo(String userId) {
		UserInfo userInfo = getUserInfo(userId);
		return userInfo.getUserNo();
	}

	@LocalCacheable(topic = USER_INFO_CACHE, maxSize = 10, keyFormat = "userInfo_{}")
	private UserInfo getUserInfo(@CacheKey String userId) {
		return userInfoDao.getUserInfo(userId);
	}
}