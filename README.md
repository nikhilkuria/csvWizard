csvCompare
==========

csvCompare comapares two .csv files or any delimited files. 

The changes can be printed out to an html report.

The comparision and report is configurable via a configuration file. 

It is a library and looks better with a web front end. 

--Usage Details--

Two major entry points

1) CsvComparer
    Can take in two files and give a comparision report in the form of a CompareOutput object

2) ReportGenerator
    Can take in the CompareOutput object and output an html report

Configuration file 

Has to be initialized via ConfigurationsManager.initializeManager()

Will accept a file with the following format. Plus more options to customize inline

#--UNIQUE ROW IDENTIFICATION--#

#IMPORTANT - Please chose either of option 1 and 2. 
#If both are chosen, Only option 1 will be considered

#It is alright to do a blind compare with both options disabled

#---1---IDENTITY USING AN UNIQUE KEY ( primary key )
#Used to identify an unique row like the primary key in relational db
#Add delimiter separated header positions,
#If a row can be identified with first and second values, UNIQUE_KEY = 1,2
#If there is no unique key, UNIQUE_KEY = 0
UNIQUE_KEY=1
#---2---COMPARE ROWS WITH SAME ROW NUMBER 
#Pretty straight forward, comapre row n in file #1 with row n in file #2
#Set CONSIDER_ORDER=TRUE to enable and CONSIDER_ORDER=FALSE to disable
CONSIDER_ORDER=TRUE

#Set this property to TRUE if the csv has a header row. Set to false, if otherwise
#Setting the value TRUE considers the first line as header
COMPARE_HEADERS=TRUE

#The separator in the file
CSV_DELIMITER=,

COLOR_MAPPING=TRUE
SHOW_COMMON_HEADERS=TRUE
SHOW_COMMON_ROWS=TRUE

SHOW_LINE_NUMBERS=TRUE

REPORT_LOCATION=<add report path here>

--Release History--

v1.0 - 27 Mar 2014
v2.0 - 31 Mar 2014

