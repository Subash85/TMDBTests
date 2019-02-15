The framework follows BDD approach to write and execute the test cases.
Technology used Cucumber , Gherkins language , Rest-Assured , TestNG, Java.

Test data

•	Some of the test data is provided in the Feature files in the test folders
•	Sensitive data can be entered from config files too
•	I can also use TestNg “@dataProviders ” to get the data.
•	Another enhancement which I can do on this  framework is to read the test data from MS Excel Sheet / text file.

Test Execution

•	One can execute the test using the testing.Xml or choosing to run from the TestRunner file.
•	I have grouped the test using tags such as  “@movie & @tv”.  This allows you to run the tests for movies and tv shows separately or combined.
    This can be achieved by removing/adding the tags in cucumber options in the TestRunner file.We can use the tags to group the test needed
    for smoke or regression test without need for writing separate test cases. Each scenario can have multiple tags.
•	I can further enhance to run the test parallel using TestNg / cucumber


Test Results
•	The test results will be uploaded in the test-output folder on the runtime. Index.Html which can be opened with any browser would have  all results in the readable  format
•	Real time logs can be viewed in the console.
