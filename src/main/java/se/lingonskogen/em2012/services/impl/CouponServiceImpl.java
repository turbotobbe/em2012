package se.lingonskogen.em2012.services.impl;

import java.util.List;

import se.lingonskogen.em2012.domain.Coupon;
import se.lingonskogen.em2012.domain.CouponDao;
import se.lingonskogen.em2012.domain.DaoException;
import se.lingonskogen.em2012.services.CouponService;

public class CouponServiceImpl implements CouponService {

	private CouponDao couponDao;
	@Override
	public String createCoupon(final Coupon coupon) throws DaoException {
		return couponDao.create(coupon);
	}

	@Override
	public Coupon newInstance(final String tournamentId, final String userId, final String groupId) {
		Coupon coupon = new Coupon();
		coupon.setGroupId(groupId);
		coupon.setTournamentId(tournamentId);
		coupon.setUserId(userId);
		return coupon;
	}

	public Coupon getCoupon(final String groupId, final String userId, final String couponId) throws DaoException {
		return couponDao.find(groupId, userId, couponId);
	}
	
	@Override
	public List<Coupon> getAvailableCoupons() {
		return couponDao.findAll();
	}

	public void setCouponDao(final CouponDao couponDao) {
		this.couponDao = couponDao;
	}

	@Override
	public void deleteCoupon(final Coupon coupon) throws DaoException {
		couponDao.delete(coupon);
	}
	
	@Override
	public void deleteCoupon(final String couponId, final String userId, final String groupId) throws DaoException {
		Coupon coupon = couponDao.find(groupId, userId, couponId);
		deleteCoupon(coupon);
		
	}
}