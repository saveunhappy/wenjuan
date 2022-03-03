package com.course.server.dto;

public class PlantPageDto extends PageDto{
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PlantPageDto{" +
                "status='" + status + '\'' +
                "} " + super.toString();
    }
}
