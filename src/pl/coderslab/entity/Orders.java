package pl.coderslab.entity;

public class Orders {

	private int id;
	private String commisioningDate;
	private String scheduledFixingStartDate;
	private String fixingStartDate;
	private String problemDescription;
	private String fixingDescription;
	private int status = 0;
	private double fixingCost;
	private double usedPartsCost;
	private double manHoursCost;
	private int manHoursAmount;
	private int workerId;
	private int vehicleId;
	
	
	public Orders() {
		
	}
	
	public Orders(int id, String commisioningDate, String scheduledFixingStartDate, String fixingStartDate,
			String problemDescription, String fixingDescription, int status, double fixingCost, double usedPartsCost,
			double manHoursCost, int manHoursAmount, int workerId, int vehicleId) {
		super();
		
		setCommisioningDate(commisioningDate);
		setScheduledFixingStartDate(scheduledFixingStartDate);
		setFixingStartDate(fixingStartDate);
		setProblemDescription(problemDescription);
		setFixingDescription(fixingDescription);
		setStatus(status);
		setFixingCost(fixingCost);
		setUsedPartsCost(usedPartsCost);
		setManHoursCost(manHoursCost);
		setManHoursAmount(manHoursAmount);
		setWorkerId(workerId);
		setVehicleId(vehicleId);
	}
	
	public int getId() {
		return id;
	}
	
	public String getCommisioningDate() {
		return commisioningDate;
	}
	public void setCommisioningDate(String commisioningDate) {
		this.commisioningDate = commisioningDate;
	}
	public String getScheduledFixingStartDate() {
		return scheduledFixingStartDate;
	}
	public void setScheduledFixingStartDate(String scheduledFixingStartDate) {
		this.scheduledFixingStartDate = scheduledFixingStartDate;
	}
	public String getFixingStartDate() {
		return fixingStartDate;
	}
	public void setFixingStartDate(String fixingStartDate) {
		this.fixingStartDate = fixingStartDate;
	}
	public String getProblemDescription() {
		return problemDescription;
	}
	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}
	public String getFixingDescription() {
		return fixingDescription;
	}
	public void setFixingDescription(String fixingDescription) {
		this.fixingDescription = fixingDescription;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		if (status >= 1 && status <= 5) {
			this.status = status;
		}
	}
	public double getFixingCost() {
		return fixingCost;
	}
	public void setFixingCost(double fixingCost) {
		this.fixingCost = fixingCost;
	}
	public double getUsedPartsCost() {
		return usedPartsCost;
	}
	public void setUsedPartsCost(double usedPartsCost) {
		this.usedPartsCost = usedPartsCost;
	}
	public double getManHoursCost() {
		return manHoursCost;
	}
	public void setManHoursCost(double manHoursCost) {
		this.manHoursCost = manHoursCost;
	}
	public int getManHoursAmount() {
		return manHoursAmount;
	}
	public void setManHoursAmount(int manHoursAmount) {
		this.manHoursAmount = manHoursAmount;
	}
	public int getWorkerId() {
		return workerId;
	}
	public void setWorkerId(int workerId) {
		this.workerId = workerId;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
}
