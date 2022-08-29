<p align="center">
<img src="src/main/resources/img/Logo_Team_Project.png"/>
</p>

---

This is our app to manage internal recruitment processes for NTT DATA Spain and Affiliates.

Here you can add, edit or delete candidates, interviewers, interviews, processes and view statistics on the selection processes.

### :link: **Links to project:**
#### :arrow_right: FrontEnd:
https://github.com/checkmyprojects/recruitment-process-frontend

#### :arrow_left: Backend:
https://github.com/checkmyprojects/recruitment-process-backend
## :wrench: How It's Made:

### :space_invader: Technologies
<p align="left">
<a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/><span>Java</span> </a>
<a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> <span>Spring Boot</span></a>
<a href="#" target="_blank" rel="noreferrer"> <img src="https://huongdanjava.com/wp-content/uploads/2021/05/spring-security-logo.png" alt="java" width="70" height="40"/><span>Spring Security</span> </a>

<a href="https://jwt.io/" target="_blank" rel="noreferrer"> <img src="https://jwt.io/img/pic_logo.svg" alt="mysql" width="40" height="40"/> <span>JWT</span></a>
<a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/> <span>MySQL</span></a>
<a href="#" target="_blank" rel="noreferrer"> <img src="https://cleventy.com/wp-content/uploads/2020/05/javamail.png" alt="javax.mail" width="40" height="40"/><span>javax.mail</span> </a>


</p>

- With **Springboot** to power our fullstack application, we made a responsive website to manage selection processes.
- **javax.mail** facilitates sending and receiving e-mail from java code through SMTP, POP3 and IMAP protocols.
- **Local secondary index (LSI)** allows us to perform a query on a single Hash-Key using several different attributes to "filter" or restrict the query.

Our goal is to facilitate the hiring process of the HR department, bringing together all the roles in a single app.



---


### :checkered_flag: Team


Hi there!

We are a group of enthusiastic coders excited about web developers. In our latest project we have created a web application for the HR department.

##### Scrum Master/developer
- [Jesús Vázquez](https://github.com/checkmyprojects)

##### Product Owner/developer

- [Lupe Flores](https://github.com/Lupe13)

##### Developers

- [Fran Domínguez](https://github.com/devfdom)
- [Samuel Alonso](https://github.com/Lupe13)
- [Elisabeth Ildeeva](https://github.com/ElisabethIld)


:memo: Lessons Learned:
---


---


# API Documentation

### Base Path: /api
## Users
### Return a list of users with roles and orders
```GET: /admin/users```
```json
[

      {
        "id": 13,
        "candidate": {
          "id": 1,
          "name": "Francisco",
          "surname": "Domínguez",
          "email": "frando@mail.com",
          "skills": "Angular, Typescript, Java",
          "studies": "F.P.",
          "location": "Sevilla",
          "experience": 1,
          "hired": false,
          "state": null,
          "phone": null,
          "notes": null
        },
        "selection": {
          "id": 5,
          "created_by": {
            "id": 1,
            "name": "usuario",
            "username": "user",
            "email": "user@mail.com",
            "roles": [
              {
                "id": 4,
                "name": "ROLE_PEOPLE"
              },
              {
                "id": 6,
                "name": "ROLE_INTERVIEWER"
              }
            ],
            "active": true
          },
          "start_date": "2022-09-12",
          "end_date": null,
          "name": "Java Spring Boot",
          "description": "Senior Java Team manager",
          "requirements": "Java, Spring Boot",
          "location": "Sevilla",
          "sector": "Health",
          "status": "Active",
          "priority": "High",
          "project_id": 123123123,
          "remote": false
        },
        "status": null,
        "feedback": "",
        "interview_date": "2022-08-22 / 09:11:33",
        "creation_date": "2022-08-14 / 20:52:50"
      },
      {
        "id": 39,
        "candidate": {
          "id": 49,
          "name": "Arvie",
          "surname": "Hiley",
          "email": "ahiley1c@sciencedaily.com",
          "skills": "Namfix",
          "studies": "Administrative Officer",
          "location": "Yangjiafang",
          "experience": 3,
          "hired": true,
          "state": "",
          "phone": null,
          "notes": null
        },
        "selection": {
          "id": 5,
          "created_by": 1,
          "start_date": "2022-09-12",
          "end_date": null,
          "name": "Java Spring Boot",
          "description": "Senior Java Team manager",
          "requirements": "Java, Spring Boot",
          "location": "Sevilla",
          "sector": "Health",
          "status": "Active",
          "priority": "High",
          "project_id": 123123123,
          "remote": false
        },
        "status": null,
        "feedback": "",
        "interview_date": "2022-08-18 / 13:23:21",
        "creation_date": "2022-08-18 / 13:23:23"
      }
    ],
    "active": true
  },
  
]
```
### Return a user by {id} with roles and orders
```GET: /admin/users/{id}```
```json
{
  "id": 29,
  "candidate": {
    "id": 57,
    "name": "Aldrich",
    "surname": "Battelle",
    "email": "abattelle1k@altervista.org",
    "skills": "Greenlamd",
    "studies": "Automation Specialist II",
    "location": "Stockholm",
    "experience": 5,
    "hired": true,
    "state": "activo",
    "phone": null,
    "notes": null
  },
  "selection": {
    "id": 5,
    "created_by": 1,
    "start_date": "2022-09-12",
    "end_date": null,
    "name": "Java Spring Boot",
    "description": "Senior Java Team manager",
    "requirements": "Java, Spring Boot",
    "location": "Sevilla",
    "sector": "Health",
    "status": "Active",
    "priority": "High",
    "project_id": 123123123,
    "remote": false
  },
  "status": null,
  "feedback": "",
  "interview_date": "2022-08-18 / 11:15:14",
  "creation_date": "2022-08-18 / 11:15:18"
},
}
```
### Return the authed user username
```GET: /admin/users/whoami```
```json
"test@mail.com"
```
### Create new user
```POST: /auth/signup```

body: JSON
```json
{
  "id": 44,
  "name": "Jesús",
  "username": "yisus",
  "email": "admin1@mail.com",
  "roles": [
    {
      "id": 3,
      "name": "ROLE_ADMIN"
    }
  ],
  "interviews": null,
  "active": true
}
```
### Create new role
```POST: /admin/role/save```

body: JSON
```json
{
    "name": "ROLE_ADMIN",
}
```
### Add role to user
```POST: /admin/role```

body: JSON
```json
{
    "username": "test@mail.com",
    "rolename": "ROLE_ADMIN",
}
```

### User login returns JWT token
```POST: /auth/signin```


```json
{
  "id": 2,
  "username": "admin",
  "email": "admin@mail.com",
  "roles": [
    "ROLE_ADMIN"
  ],
}
```

Returns:

```json
{
  "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGhvcml0aWVzIjpbIlJPTEVfQURNSU4iXSwiZW1haWwiOiJhZG1pbkBtYWlsLmNvbSIsImlhdCI6MTY2MTc3MzczOCwiZXhwIjoxNjYxODYwMTM4fQ.JUhaPITEW3ObLyyMkkGF9jpgQnxGxJLURVgPqBArK4PcYgeqaZ33LY3vE6qLII-QtCjjfvs0XPM388KhoKDXkw",
  "tokenType": "Bearer"
}
```

### List All Candidates
```GET: /candidate/list```


```json
{
  "id": 52,
  "name": "Melissa",
  "surname": "Wayte",
  "email": "mwayte1f@dyndns.org",
  "skills": "Overhold",
  "studies": "Structural Analysis Engineer",
  "location": "Caçador",
  "experience": 16,
  "hired": true,
  "state": "",
  "phone": null,
  "notes": null,
  "interviews": []
},
{
"id": 53,
"name": "Denis",
"surname": "Elia",
"email": "delia1g@usda.gov",
"skills": "Fix San",
"studies": "Automation Specialist III",
"location": "Lunao",
"experience": 30,
"hired": true,
"state": "",
"phone": null,
"notes": null,
"interviews": []
},
{
"id": 54,
"name": "Noach",
"surname": "Wakenshaw",
"email": "nwakenshaw1h@tinyurl.com",
"skills": "Asoka",
"studies": "Senior Cost Accountant",
"location": "Rancanyenang",
"experience": 11,
"hired": true,
"state": "",
"phone": null,
"notes": null,
"interviews": []
},
```
### New Candidate
```GET: /candidate/new```
```json
{
  "id": 107,
  "name": "Samuel",
  "surname": "Alonso",
  "email": "alsa@mail.com",
  "skills": "Angular, Typescript, Java",
  "studies": "F.P.",
  "location": "Pamplona",
  "experience": 1,
  "hired": false,
  "state": null,
  "phone": null,
  "notes": null,
  "interviews": null
}
```
### List Selection Process
```GET: /selection/list```
```json
[
  {
    "id": 5,
    "created_by": {
      "id": 1,
      "name": "usuario",
      "username": "user",
      "email": "user@mail.com",
      "roles": [
        {
          "id": 3,
          "name": "ROLE_ADMIN"
        }
      ],
      "active": true
    },
    "start_date": "2022-09-12",
    "end_date": null,
    "name": "Java Spring Boot",
    "description": "Senior Java Team manager",
    "requirements": "Java, Spring Boot",
    "location": "Sevilla",
    "sector": "Health",
    "status": "Active",
    "priority": "High",
    "project_id": 123123123,
    "remote": false,
    "interviews": [
      {
        "id": 17,
        "candidate": {
          "id": 1,
          "name": "Francisco",
          "surname": "Domínguez",
          "email": "frando@mail.com",
          "skills": "Angular, Typescript, Java",
          "studies": "F.P.",
          "location": "Sevilla",
          "experience": 1,
          "hired": false,
          "state": null,
          "phone": null,
          "notes": null
        },
        "interviewer": {
          "id": 1,
          "name": "usuario",
          "username": "user",
          "email": "user@mail.com",
          "roles": [
            {
              "id": 3,
              "name": "ROLE_ADMIN"
            }
          ],
          "active": true
        },
        "status": null,
        "feedback": "",
        "interview_date": "2022-08-31 / 10:10:03",
        "creation_date": "2022-08-14 / 22:14:12"
      },
]
```
### Return food by category
```GET: /food/filter/{categoryName}```

(/food/filter/drink)
```json
[
    {
        "id": 16,
        "name": "Coca Cola",
        "type": "drink",
        "ingredients": "Cola",
        "vegan": false,
        "alergies": "none",
        "price": 2.0,
        "img": "assets/img/product/drink-cocacola.png"
    },
    {
        "id": 17,
        "name": "Fanta Naranja",
        "type": "drink",
        "ingredients": "Fanta",
        "vegan": false,
        "alergies": "none",
        "price": 2.0,
        "img": "assets/img/product/drink-fanta-orange.png"
    }
]
```
### Add new food
```POST: /food/save```
```json
{
        "name": "Classic grilled sandwich",
        "type": "sandwich",
        "ingredients": "Ham, tomato",
        "vegan": false,
        "alergies": "none",
        "price": 5.0,
        "img": "assets/img/product/sandwich-classic-grilled.png"
}
```
Returns:
```json
{
        "name": "Classic grilled sandwich",
        "type": "sandwich",
        "ingredients": "Ham, tomato",
        "vegan": false,
        "alergies": "none",
        "price": 5.0,
        "img": "assets/img/product/sandwich-classic-grilled.png"
}
```
### Edit food
```PUT: /food/edit```
```json
{
        "id": 30,
        "name": "Classic grilled sandwich 2",
        "type": "sandwich",
        "ingredients": "Ham, tomato",
        "vegan": false,
        "alergies": "none",
        "price": 5.0,
        "img": "assets/img/product/sandwich-classic-grilled.png"
}
```
Returns:
```json
{
        "id": 30,
        "name": "Classic grilled sandwich 2",
        "type": "sandwich",
        "ingredients": "Ham, tomato",
        "vegan": false,
        "alergies": "none",
        "price": 5.0,
        "img": "assets/img/product/sandwich-classic-grilled.png"
}
```
### Delete food by id
```DELETE: /food/delete/{id}```

(/food/delete/3)



## Orders
### Return all orders
```GET: /orders```
```json
[
    {
        "id": 29,
        "quantity": 1,
        "uuid": "cc57007c-2c43-4b8c-a711-1e6fba2b1200",
        "food": {
            "id": 16,
            "name": "Coca Cola",
            "type": "drink",
            "ingredients": "Cola",
            "vegan": false,
            "alergies": "none",
            "price": 2.0,
            "img": "assets/img/product/drink-cocacola.png"
        }
    },
    {
        "id": 30,
        "quantity": 1,
        "uuid": "cc57007c-2c43-4b8c-a711-1e6fba2b1200",
        "food": {
            "id": 14,
            "name": "Double Burger",
            "type": "burger",
            "ingredients": "Double burger",
            "vegan": false,
            "alergies": "none",
            "price": 30.0,
            "img": "assets/img/product/burger-doubleburger.png"
        }
    }
]
```
### Return user with id {id} orders list
```GET: /orders/{id}```
```json
[
    {
        "id": 29,
        "quantity": 1,
        "uuid": "cc57007c-2c43-4b8c-a711-1e6fba2b1200",
        "food": {
            "id": 16,
            "name": "Coca Cola",
            "type": "drink",
            "ingredients": "Cola",
            "vegan": false,
            "alergies": "none",
            "price": 2.0,
            "img": "assets/img/product/drink-cocacola.png"
        }
    },
    {
        "id": 30,
        "quantity": 1,
        "uuid": "cc57007c-2c43-4b8c-a711-1e6fba2b1200",
        "food": {
            "id": 14,
            "name": "Double Burger",
            "type": "burger",
            "ingredients": "Double burger",
            "vegan": false,
            "alergies": "none",
            "price": 30.0,
            "img": "assets/img/product/burger-doubleburger.png"
        }
    }
]
```
### Create orders for authenticated user (send item with quantity when doing checkout)
Can send a list of quantity + food and all of them will have the same unique uuid to know that they come from the same checkout.

```POST: /orders/checkout```
```json
[
    {
        "quantity": 2,
        "food": {
            "id": 14,
            "name": "Double Burger",
            "type": "burger",
            "ingredients": "Double burger",
            "vegan": false,
            "alergies": "none",
            "price": 30.0,
            "img": "assets/img/product/burger-doubleburger.png"
        }
    }
]
```

### License

This project is licensed under the **Entiteam** License - see the file [LICENSE.md](LICENSE.md) for details.

### Thanks 🎁

* Tell others about this project 📢
* Invite someone from the team to a beer 🍺 or a coffee ☕.
* Give thanks publicly 🤓.
* etc.



---