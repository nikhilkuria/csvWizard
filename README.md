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

Will accept a file with the following format

HEADER_PRESENT=TRUE <br>
COMPARE_HEADERS=TRUE <br>
CASE_SENSITIVE_HEADERS=TRUE <br>
CASE_SENSITIVE_CONTENT=TRUE <br>
UNIQUE_KEY=0 <br>
CONSIDER_ORDER=FALSE <br>
CSV_DELIMITER=, <br>
COLOR_MAPPING=TRUE <br>
SHOW_COMMON_HEADERS=TRUE <br>
SHOW_COMMON_ROWS=TRUE <br>

REPORT_LOCATION=C:/Temp/CPT_TOOLS/CSV_COMPARE/report.html


--Release History--

v1.0 - 27 Mar 2014


