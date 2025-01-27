Part 2: Spring Bean Life Cycle and Scopes

explain in 2-3 sentences how the code worked (when init() got called) and why the number of calls to init() where made.


1. Scope Prototype
1. A new instance of OrdersBusinessService is created each time it is requested or injected into a controller. 
Meaning, every time the form is submitted, the init() method is called

2. Request Scope
2. A new instance of OrdersBusinessService is created each time the login form page is requested. The init()
 method is called once per request to the login page. This means the method is only called once per form submission

3. Session Scope
3. A new instance of OrdersBusinessService is created for each browser session. init() was only called once, even 
though the form was submitted multiple times. Each session only has one call to init()

4. Singleton Scope
4. Only one instance of OrdersBusinessService is created during the application. So no matter how many times the 
form is submitted or a new session is opened, init() will only be called once
