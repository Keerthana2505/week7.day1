Feature: Edit a lead in Leaftaps Application

Background: Positive Login
Given Type the username as 'Demosalesmanager'
And Type the password as 'crmsfa'
When Click on the Login button
Then Verify the home page is displayed

Scenario Outline: Create Lead with different data
Given Click CRM SFA Link
And Click on Leads Tab
And Click Find Leads Link
When Enter the First Name as <fName>
And Click Find Leads Button
And Click First Resulting Lead
When CLick Edit Button
And Clear and Type Company Name as <cName>
And Click Update Button
Then Verify the View Lead Opentaps CRM Page

Examples:
|fName|cName|
|Keerthana|Zoho|
