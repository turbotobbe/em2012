package se.lingonskogen.em2012.domain;

import java.util.List;
import java.util.logging.Logger;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.KeyFactory.Builder;

public class CouponDao extends AbstractDao<Coupon> {
	
	private Logger LOG = Logger.getLogger(CouponDao.class.getName());
	
	@Override
	protected void populateEntity(Entity entity, Coupon coupon) {
		entity.setProperty(Coupon.TOURNAMENT, coupon.getTournamentId());
		entity.setProperty(Coupon.WINNER, coupon.getWinnerTeamId());
	}

	@Override
	protected Coupon createBean(Entity entity) {
		Coupon coupon = new Coupon();
		coupon.setId(entity.getKey().getName());
		coupon.setGroupId(entity.getParent().getParent().getName());
		coupon.setUserId(entity.getParent().getName());
		coupon.setTournamentId((String) entity.getProperty(Coupon.TOURNAMENT));
		coupon.setWinnerTeamId((String) entity.getProperty(Coupon.WINNER));
		return coupon;
	}

	public String create(Coupon coupon) throws DaoException {
		String couponId = createId(coupon);
		Key key = createKey(coupon.getGroupId(), coupon.getUserId(), couponId);
		super.create(key, coupon);
		return couponId;
	}

	public void update(Coupon coupon) throws DaoException {
		String couponId = createId(coupon);
		Key key = createKey(coupon.getGroupId(), coupon.getUserId(), couponId);		
		super.update(key, coupon);
	}

	public void delete(Coupon coupon) throws DaoException {
		String couponId = createId(coupon);
		Key key = createKey(coupon.getGroupId(), coupon.getUserId(), couponId);
		super.delete(key);
	}

	public Coupon find(final Key key) throws DaoException {
		return super.find(key);
	}
	
	public Coupon find(String groupId, String userId, String couponId)
			throws DaoException {
		Key key = createKey(groupId, userId, couponId);
		return find(key);
	}

	public List<Coupon> findAll() {
		List<Coupon> list = super.findAll(Coupon.class.getSimpleName(), null);
		return list;
	}

	public List<Coupon> findAll(String groupId) {
		Key key = createKey(groupId);
		List<Coupon> list = super.findAll(Coupon.class.getSimpleName(), key);
		return list;
	}

	public List<Coupon> findAll(String groupId, String userId) {
		Key key = createKey(groupId, userId);
		List<Coupon> list = super.findAll(Coupon.class.getSimpleName(), key);
		return list;
	}

	private String createId(Coupon coupon) {
		return coupon.getTournamentId();
	}

	private Key createKey(String groupId) {
		Builder builder = new KeyFactory.Builder(Group.class.getSimpleName(),
				groupId);
		return builder.getKey();
	}

	private Key createKey(String groupId, String userId) {
		Builder builder = new KeyFactory.Builder(Group.class.getSimpleName(),
				groupId);
		builder.addChild(User.class.getSimpleName(), userId);
		return builder.getKey();
	}

	private Key createKey(String groupId, String userId, String couponId) {
		Builder builder = new KeyFactory.Builder(Group.class.getSimpleName(),
				groupId);
		builder.addChild(User.class.getSimpleName(), userId);
		builder.addChild(Coupon.class.getSimpleName(), couponId);
		return builder.getKey();
	}

	@Override
	protected Logger getLogger() {
		return LOG;
	}

	@Override
	protected String getType() {
		return "Coupon";
	}

}
