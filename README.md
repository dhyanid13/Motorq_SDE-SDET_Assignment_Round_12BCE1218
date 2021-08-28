# Motorq_SDE-SDET_Assignment_Round_12BCE1218

# Name : Desai Dhyani Dhaval  Reg_No :19BCE1218


## TASK : To build a Course Slot Booking System

In the above submission  a CLI application for Course Slot Booking System built in JAVA implemented using OOPs

## Functions Implemented :
* View all courses available during the registration slot
* View only those courses where is the student is eligible to apply(Where seats are still vacant)
* Register for a course
* Get added in the waiting list if the 0 seats are vacant
* Withdraw from any given course
* Get added to a course automatically if seats empty for a given course


## Dummy Database using a csv file:
The follwoing csv files contains all availabe couses and their specifications as show below.Due to the csv file the application can be implemented dynamically by adding,removing or modifying any course specification


![mtrq1](https://user-images.githubusercontent.com/56058074/131212476-380b328f-fc5e-47eb-b519-af254c39b989.png)

* When program is launched, the CRS must read all courses' information from a file (MyUniversityCourses.csv)
*Serialization & deserialization will be used to read the csv file and write into a new file.


## Underlying structure for each function:
#### Waiting-List 
The waiting list follows the FIFO logic to add students to a course who entered the waiting list first,hence the *queue* data structure is used
#### Sudent Class 

#### Course Class 



## Assumptions :
* Registration is open at all time of excecuting the application
* The time slot of every course is classifeid as unique slots ie
** A1- (Mon : 8:30-9:30 , Tues 4-5 , Fri 3:30-4:30)
** B1- (Tue : 8:30-9:30 , Mon 4-5 , Sat 3:30-4:30)

For a clear picture the slots have been implemented as below:
![mtrq2](https://user-images.githubusercontent.com/56058074/131212448-e9754d43-6678-4dbe-b916-b4467a5920e1.png)


