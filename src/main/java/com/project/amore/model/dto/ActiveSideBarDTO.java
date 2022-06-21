package com.project.amore.model.dto;

public class ActiveSideBarDTO {

  private boolean dashboard;
  private boolean users;
  private boolean mantenimiento;
  private boolean products;
  private boolean files;
  private boolean stats;

  public boolean isDashboard() {
    return dashboard;
  }

  public void setDashboard(boolean dashboard) {
    this.dashboard = dashboard;
  }

  public boolean isUsers() {
    return users;
  }

  public void setUsers(boolean users) {
    this.users = users;
  }

  public boolean isMantenimiento() {
    return mantenimiento;
  }

  public void setMantenimiento(boolean messages) {
    this.mantenimiento = messages;
  }

  public boolean isProducts() {
    return products;
  }

  public void setProducts(boolean products) {
    this.products = products;
  }

  public boolean isFiles() {
    return files;
  }

  public void setFiles(boolean files) {
    this.files = files;
  }

  public boolean isStats() {
    return stats;
  }

  public void setStats(boolean stats) {
    this.stats = stats;
  }
}
