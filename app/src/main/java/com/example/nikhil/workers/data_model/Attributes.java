package com.example.nikhil.workers.data_model;

import com.google.gson.annotations.SerializedName;

public class Attributes {

    private Inventories[] Inventories;

    private String role_id;

    private String contractor;

    private String deleted_at;

    private String site_id;

    private String id;

    private String first_name;

    private String updated_at;

    private String mobile_number;

    private String helmet_color;

    private String last_name;

    @SerializedName("role")
    private String role;

    @SerializedName("Role")
    private Role Role;

    private String created_at;

    private String worker_tag_id;

    private String full_name;

    public Inventories[] getInventories ()
    {
        return Inventories;
    }

    public void setInventories (Inventories[] Inventories)
    {
        this.Inventories = Inventories;
    }

    public String getRole_id ()
    {
        return role_id;
    }

    public void setRole_id (String role_id)
    {
        this.role_id = role_id;
    }

    public String getContractor ()
    {
        return contractor;
    }

    public void setContractor (String contractor)
    {
        this.contractor = contractor;
    }

    public String getDeleted_at ()
    {
        return deleted_at;
    }

    public void setDeleted_at (String deleted_at)
    {
        this.deleted_at = deleted_at;
    }

    public String getSite_id ()
    {
        return site_id;
    }

    public void setSite_id (String site_id)
    {
        this.site_id = site_id;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getFirst_name ()
    {
        return first_name;
    }

    public void setFirst_name (String first_name)
    {
        this.first_name = first_name;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getMobile_number ()
    {
        return mobile_number;
    }

    public void setMobile_number (String mobile_number)
    {
        this.mobile_number = mobile_number;
    }

    public String getHelmet_color ()
    {
        return helmet_color;
    }

    public void setHelmet_color (String helmet_color)
    {
        this.helmet_color = helmet_color;
    }

    public String getLast_name ()
    {
        return last_name;
    }

    public void setLast_name (String last_name)
    {
        this.last_name = last_name;
    }

    public String getRoleString ()
    {
        return role;
    }

    public void setRoleString (String role)
    {
        this.role = role;
    }

    public Role getRole ()
    {
        return Role;
    }

    public void setRole (Role Role)
    {
        this.Role = Role;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public String getWorker_tag_id ()
    {
        return worker_tag_id;
    }

    public void setWorker_tag_id (String worker_tag_id)
    {
        this.worker_tag_id = worker_tag_id;
    }

    public String getFull_name ()
    {
        return full_name;
    }

    public void setFull_name (String full_name)
    {
        this.full_name = full_name;
    }
}
