package fr.justop.players;

import java.util.Arrays;
import java.util.Objects;

public class JobsProfile {

	private int mineurXp;
	private int farmeurXp;
	private int chasseurXp;
	private int mecaXp;
	private int pecheurXp;
	private int bucheronXp;

	private int exploXp;

	private int browseSchema;
	private int[] rewardsAchieved;

	public JobsProfile(int mineurXp, int farmeurXp, int chasseurXp, int mecaXp, int pecheurXp, int bucheronXp, int exploXp, int browseSchema, int[] rewardsAchieved) {
		this.browseSchema = browseSchema;
		this.bucheronXp = bucheronXp;
		this.chasseurXp = chasseurXp;
		this.mecaXp = mecaXp;
		this.farmeurXp = farmeurXp;
		this.mineurXp = mineurXp;
		this.pecheurXp = pecheurXp;
		this.rewardsAchieved = rewardsAchieved;
		this.exploXp = exploXp;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JobsProfile that = (JobsProfile) o;
		return mineurXp == that.mineurXp && farmeurXp == that.farmeurXp && chasseurXp == that.chasseurXp && mecaXp == that.mecaXp && pecheurXp == that.pecheurXp && bucheronXp == that.bucheronXp && browseSchema == that.browseSchema && Arrays.equals(rewardsAchieved, that.rewardsAchieved);
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(mineurXp, farmeurXp, chasseurXp, mecaXp, pecheurXp, bucheronXp, exploXp, browseSchema);
		result = 31 * result + Arrays.hashCode(rewardsAchieved);
		return result;
	}

	@Override
	public String toString() {
		return "JobsProfile{" +
				"mineurXp=" + mineurXp +
				", farmeurXp=" + farmeurXp +
				", chasseurXp=" + chasseurXp +
				", mecaXp=" + mecaXp +
				", pecheurXp=" + pecheurXp +
				", bucheronXp=" + bucheronXp +
				", exploXp=" + exploXp +
				", browseSchema=" + browseSchema +
				", rewardsAchieved=" + Arrays.toString(rewardsAchieved) +
				'}';
	}

	public int getMineurXp() {
		return mineurXp;
	}

	public void setMineurXp(int mineurXp) {
		this.mineurXp = mineurXp;
	}

	public int getFarmeurXp() {
		return farmeurXp;
	}

	public void setFarmeurXp(int farmeurXp) {
		this.farmeurXp = farmeurXp;
	}

	public int getChasseurXp() {
		return chasseurXp;
	}

	public void setChasseurXp(int chasseurXp) {
		this.chasseurXp = chasseurXp;
	}

	public int getMecaXp() {
		return mecaXp;
	}

	public void setMecaXp(int mecaXp) {
		this.mecaXp = mecaXp;
	}

	public int getPecheurXp() {
		return pecheurXp;
	}

	public void setPecheurXp(int pecheurXp) {
		this.pecheurXp = pecheurXp;
	}

	public int getBucheronXp() {
		return bucheronXp;
	}

	public void setBucheronXp(int bucheronXp) {
		this.bucheronXp = bucheronXp;
	}

	public int getExploXp() {
		return exploXp;
	}

	public void setExploXp(int exploXp) {
		this.exploXp = exploXp;
	}

	public int getBrowseSchema() {
		return browseSchema;
	}

	public void setBrowseSchema(int browseSchema) {
		this.browseSchema = browseSchema;
	}

	public int[] getRewardsAchieved() {
		return rewardsAchieved;
	}

	public void setRewardsAchieved(int rewardsAchieved, int job) {
		this.rewardsAchieved[job] = rewardsAchieved;
	}


}
