package se.lingonskogen.em2012.domain;

public class Prediction extends Bean {
	public static final String TOURNAMENT = "tournament";

	public static final String HOMESCORE = "homeScore";

	public static final String AWAYSCORE = "awayScore";

	public static final String GAME = "game";

	private String groupId;

	private String userId;

	private String couponId;

	private String tournamentId;

	private String gameId;

	private Long homeScore;

	private Long awayScore;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public String getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public Long getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(Long homeScore) {
		this.homeScore = homeScore;
	}

	public Long getAwayScore() {
		return awayScore;
	}

	public void setAwayScore(Long awayScore) {
		this.awayScore = awayScore;
	}

}
