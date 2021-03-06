package com.cg.flightmgmt.Entity;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="schedule_Id")
	private int scheduleId;
	
	@OneToOne(targetEntity=Airport.class,cascade=CascadeType.ALL)
	@JoinColumn(name="source_airport_Code",referencedColumnName="airport_Code")
	private  Airport sourceAirport;
	
	@OneToOne(targetEntity=Airport.class,cascade=CascadeType.ALL)
	@JoinColumn(name="destination_airport_Code",referencedColumnName="airport_Code")
	private  Airport destinationAirport;


	@Column(name="arrival_Time")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private  LocalDateTime arrivalTime;
	
	@Column(name="departure_Time")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime departureTime;
	
}
