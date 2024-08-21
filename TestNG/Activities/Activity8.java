<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite parallel="classes" name="FSTTests">
  <test name="Activities">
	<parameter name="username" value="admin"/>
    <parameter name="password" value="password"/>
    <classes>
      <class name="Activities.Activity4_Demo1"/>
      <class name="Activities.Activity4_Demo2"/>  
      <class name="Activities.Activity1"/>
      <class name="Activities.Activity2"/>
      <class name="Activities.Activity3"/>
      <class name="Activities.Activity5"/>
      <class name="Activities.Activity6"/>
      <class name="Activities.Activity7"/>
      
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->