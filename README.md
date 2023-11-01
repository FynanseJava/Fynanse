# Fynanse
A web application in Java to manage personal transaction

## ABSTRACT
Saving money is an essential part of anybody’s life. Specially students. But sadly, most of the students, even us, face difficulty keeping tabs on where we spend our money. We don’t see how much daily budget we have, nor how much we are spending every week or month. That is why the proposed system will help general people to manage their accounts and keeps tabs on it as needed. A complete system where the user can create an account on the website and in the dashboard can see his/her account information, add or remove money, tune some settings and access to a history page with how much money is being spent and the category of it.
## Methodology

The user creates an account if the user is not registered. Other wise can just login with his credentials.  ![Login Page](https://lh7-us.googleusercontent.com/1Q2i5G90Uc3CgeDCRFvKF8kRY9rgAUown-oL0o9dOJ7jrYain0QZ5wBhQfCYsHZWciDIBUK1a4EfAheRRW8j-fH0S-k38yW6MFI28V6LGUxrhV2rRAKe_uNO9vdoEGUuu_7exjU-FyuvrgJWbhU8d1w)



![](https://lh7-us.googleusercontent.com/Y7opTcSE_aeqO4ot0oIV5Y8ekd5A8qmw8ta0b_G6GkfX3G_TyOeCgkr0yadMUzQj6YI4yH-kWKeeThXMHAz-DIeLxaw4mq2M7crmfdDa-pvYzq45eRsSxYbQJ8NcM6bAJIqpXnRkPMuaH6FCiXkeHpk)



The user after login or signup is redirected to the dashboard of the app.

![](https://lh7-us.googleusercontent.com/hxCy5kSliV25tZ6DjSIfbVTzv7gkvg6LYYk1bCiQm-GDUk9rwxYIWXq8RdXwPDJ9mJQ7_3L6jT9wYkk-FPgI6K-ftY6K6O11L648oOAU6BXD3hBoheDyluAWm7EbFf20XYn4jlYmcFIMpaIztK8gqwg)



Where the user can see all the information about his account in a statistical manner.

The user can then access the income or spending page.

  

![](https://lh7-us.googleusercontent.com/vO6gtfTocxO3qQQXnxwlhb44C2uwTQCKOeWtY8U35V9uOgccoIZ_JJc0ucDsD9N1avDFFy4ZseE9ckG0zIybe3ZuJChAyk-QKcXO4AJ4blprzH56r5NP6Z1ZbvjyPC-bOvaDWQa9Y1BUMLVfcfcpOIk)![](https://lh7-us.googleusercontent.com/mPQaj-hGOkZN2PEpiyayr06pswqa9z5DsJ0k6iD69sOZUz5pqKRUcI6hFA1_TxFggWBgvSQQcio1Uv-8B75pHNU2FCmsM_R5mXbVI7dXmkyMk9djup0pq0i2gbX9hkKcBBj27B-osfNQWrSVI9eAd7M)

He can access the settings page

![](https://lh7-us.googleusercontent.com/ZKl8StQsEIBJFa5K3O791AyOaK3T-rYhAIZ3kKQl-OFMI9dKX3OwlI8PopgJn11qzoFf-ohv5FA8DPdbjqy1RqeZaT0z_eA1ZhpJSFhotkFeUYwzc2Q4Drf-nGid4iacRMjAj5G3dX5yuAfbHNTuo7E)



He can see all of his spending histories

![](https://lh7-us.googleusercontent.com/Y4qn4qqL8tpE_SveCADLY5Xwfapkol_NOwysY8fL4nCMsMBVt5H_V0nSd5F9nraHkq2pxwXsoNpaaRevGUl5FxL5C7Cr1y2Y0MtuiQl_lQJHROoivnpDVVdWnar5UcBeFVp0mLH7cWCwqyVtfHoGsG0)

And in the about page, he can learn more about the app and its developers.

![](https://lh7-us.googleusercontent.com/wLJAkKRM9JmGfY9ut2duWvcKyczBCGKDRkQS26ZX1xr64zfTDAAWR1jPKRA24-ue_lECGmGOFD7k5guVsUPw71XuUAz2Iu3eaTnpONoxq4B4rv3TloVxEE5PImVWFbA_eiPfH603B3LLfrXu4FBr_tI)  


There is also an API for our site if any one want to integrate our application into their app totally free of cost and without any API key :)  
Fun Fact: There is a hidden **Easter Egg** page hidden in the site. See if you can find it ;)
## Hardware Requirements:

For the client, and mobile or desktop browser will support the web app. As for the server side of things, we have hosted the page on Render, which has a remote server in Singapore. In our test runs, the site runs quite smoothly on **512 MB of RAM**, **1GHz CPU** with almost **10 to 12 simultaneous users.**

# DESIGN SPECIFICATIONS

## Introduction

Our application has 2 parts. Frontend and backend. The frontend part is done through HTML, CSS and some JavaScript. The backend part is written with Java. The frontend developers in our team has done a modern UI look using the tailwind framework.

  
  

## Front-end  
The technologies used in frontend designs and logic based modeling are:

  

**Thymeleaf:** *Thymeleaf* is a modern server-side Java template engine for both web and standalone environments. It provides a natural and elegant way to create dynamic web pages. Thymeleaf templates are written in HTML, with additional tags and attributes that allow you to inject data and logic into the template.

  

**Tailwind:** *Tailwind CSS* is a low-level CSS framework that provides utility classes for building custom user interfaces. It is based on the idea of using small, reusable CSS classes to compose complex user interfaces.

  
  

## Back-end  
The backend part is written in Java and with Spring Boot and JPA annotations. The Program's class diagram is as below.

The diagram has two parts. One the database design with Java, and then using @Controller annotations, giving logic to frontend HTML forms and showing information.  
  

### Database modeling  
The technology used to model databases is a Spring Boot Dependency called *Spring-Data-Jpa*

  
**Spring Data JPA:** Spring Data JPA is a Spring project that provides a convenient abstraction for the *Java Persistence API (JPA).* It provides a layer of code that hides the complexity of JPA, allowing you to focus on developing your application.

  

Our application has 3 models separately. *User*, *Account* and *Transaction*. User has a one-to-one relationship with Account and has a one-to-many relationship with Transaction. That way, one user can have only one account, but many transactions. The attributes of each of the classes are described in the UML at the bottom 3 tables.

  

### Controllers and Services  
The controllers and services need to communicate with the database to expand our application. So we use the JpaRepository interface and inherit it to all 3 of our repository interfaces. So *AccountRepository*, *UserRepository* and *TransactionRepository* can have created, update and delete methods to the database.  
  
Then there are services. There are 3 services in our application  
**UserService:** The service an aggregated UserRepository and uses it to define create, update, read and delete methods so that UserRepository is not needed to be directly called. In the service, the login user is created and read through HTTP sessions.  
  
The same thing is true for the *TransactionService*. There is another service that handles chronic events like updating monthly and weekly values called *ScheduledTasks*.  
  
This UserService and other services are used for dependency injection to other controllers

The controllers are where most of our logic is. As we use Thymeleaf for modeling, after each logic, a redirection string is needed to be returned.

![](https://lh7-us.googleusercontent.com/Eur3HFjUU3dTj-lYnTmjZi0w7kHEHNME9rNIOyl-APDrvpca-cc8jpHhQQzinZXrcjYEBc9Re4GAVHa1Nho87vhjchc4yrjMvrISCqso6NPjCcBxflJRtAAS7tbTXhvfbQt0S--X8t6XtB-Nl-PTbOw)

**DashboardController:** Has aggregated UserService and uses it to show and currentUser dashboard and all the relevant account information.

  

**LoginController:** This also has UserService aggregated and has a function where it handles the loginForm from the HTML.

  

**LogoutController:** It empties the session of the user and redirects the user to login.

  

**SettingsController:** Allows user to give values to the settings page form and update the currentUser from those values. It also has delete user feature.

  

**SignupController:** Shows the signup page and handles the signup form. The data given is passed to the database and saved wherever it is needed.

  

**TransactionController:** Returns the Set of transactions the User has had and renders it to the HTML using thymeleaf.

  

**UpdateAmountController:** Uses the same HTML both for deposit and withdraw. Uses clever dynamic elements to change the title accordingly. The amount is added or subtracted, and transaction history is saved via the TransactionService.

# Change Log
## Release 1.0.0
- Made it servable for hosting
- Some frontend responsiveness
- Fixed some bugs
