##csvWizard

csvWizard comapares two .csv files or any delimited files. 

The changes can be printed out to an html report.

The comparision and report is configurable via a configuration file. 

It is a library and looks better with a web front end. 

###Usage Details

Two major entry points

1) csvWizardr
    Can take in two files and give a comparision report in the form of a CompareOutput object

2) ReportGenerator
    Can take in the CompareOutput object and output an html report

Configuration file 

Has to be initialized via `ConfigurationsManager.initializeManager()`

check file for the  format. Plus more options to customize inline

###Release History

v1.0 - 27 Mar 2014 
v2.0 - 31 Mar 2014

