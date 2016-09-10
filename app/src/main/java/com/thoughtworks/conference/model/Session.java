package com.thoughtworks.conference.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;

import java.util.Calendar;
import java.util.Date;

public class Session implements Parcelable {
  private String name;
  private String description;
  @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
  private Date startTime;
  @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
  private Date endTime;
  private Category category;
  private String location;

  public Session() {
  }

  protected Session(Parcel in) {
    name = in.readString();
    description = in.readString();
    location = in.readString();
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(in.readLong());
    startTime = calendar.getTime();
    calendar.setTimeInMillis(in.readLong());
    endTime = calendar.getTime();
    category = Enum.valueOf(Category.class, in.readString());
  }

  public static final Creator<Session> CREATOR = new Creator<Session>() {
    @Override
    public Session createFromParcel(Parcel in) {
      return new Session(in);
    }

    @Override
    public Session[] newArray(int size) {
      return new Session[size];
    }
  };

  public Date getStartTime() {
    return startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public String getLocation() {
    return location;
  }

  public Session(String name, String description, Date startTime, Date endTime, Category category, String location) {
    this.name = name;
    this.description = description;
    this.startTime = startTime;
    this.endTime = endTime;
    this.category = category;
    this.location = location;
  }

  public String getDescription() {
    return description;
  }

  public String getName() {
    return name;
  }

  public Category getCategory() {
    return category;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel parcel, int i) {
    parcel.writeString(name);
    parcel.writeString(description);
    parcel.writeString(location);
    parcel.writeLong(startTime.getTime());
    parcel.writeLong(endTime.getTime());
    parcel.writeString(category.name());
  }
}