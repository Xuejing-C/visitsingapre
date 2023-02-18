# Visit Singapore
### 1. Feature List
#### Viewpoint Information Display
  * category data load
  * viewpoint list load and pagination
  * viewpoint detail display  
#### Viewpoint Search
  * search under different category
#### User Authentication
  * Registration
    * Form validation
    * Check code generation and validation
    * Activation email sending
  * Account Activation
  * Login
    * Form validation
    * Check code generation and validation
  * User Session Keeping
  * Log out
#### Favorite Viewpoint
  * Add viewpoint to favorite
  * Number of favorite display
### 2. Technology Stack
#### Presentation Tier (web)
  * html、css、Bootstrap: display
  * AJAX、jQuery: asynchronous data communication and html element manipulation
  * BeanUtils: encapsulate json data to Java Bean object
  * Servlet: controller
    * BaseServlet: reduce the number of servlet, one module one servlet rather than one function one servlet.
  * Jackson: parse Java object into json data
#### Business Tier (service)
  * Javamail: build and send activation email
  * Jedis: Java client for Redis
  * Redis: cache category data
#### Data Tier (dao)
  * MySQL: database
  * Druid: database connection pool
  * JdbcTemplate: connect to the database and execute SQL queries
#### Server
  * Tomcat