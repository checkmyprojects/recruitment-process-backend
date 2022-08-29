<p align="center">
<img src="src/main/resources/img/Logo_Team_Project.png"/>
</p>

---

This is our app to manage internal recruitment processes for NTT DATA Spain and Affiliates.

Here you can add, edit or delete candidates, interviewers, interviews, processes and view statistics on the selection processes.

### :link: **Links to project:**
#### :arrow_right: FrontEnd:
https://github.com/checkmyprojects/recruitment-process-frontend

#### :arrow_left: Backend:
https://github.com/checkmyprojects/recruitment-process-backend
## :wrench: How It's Made:

<h3 align="left">Technologies 🛠️:</h3>
<p align="left">
<a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/><span>Java</span> </a><a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> <span>Spring Boot</span></a>
    <a href="https://jwt.io/" target="_blank" rel="noreferrer"> <img src="https://jwt.io/img/pic_logo.svg" alt="mysql" width="40" height="40"/> <span>JWT</span></a><a href="https://www.mysql.com/" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/> <span>MySQL</span></a>
</p>

With Springboot to power our fullstack application, we made a responsive website to manage selection processes.

Our goal is to facilitate the hiring process of the HR department, bringing together all the roles in a single app.


---


## :checkered_flag: Team


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
```GET: /users```
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
```GET: /users/{id}```
```json
{
    "id": 1,
    "name": "A registered user",
    "address": "My address",
    "username": "user@mail.com",
    "phone": "123321123",
    "password": "$2y$13$pvhCrATlcVzhRDl0KlgdZ.cHZQTsOK9Ig3kF/AmtXxjQ4eC90m32s",
    "roles": [
        {
            "id": 2,
            "name": "ROLE_ADMIN"
        }
    ],
    "order": [
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
        }
    ]
}
```
### Return the authed user username
```GET: /users/whoami```
```json
"test@mail.com"
```
### Create new user
```POST: /users/save```

body: JSON
```json
{
    "name": "test",
    "address": "test street",
    "username": "test@mail.com",
    "phone": "123321123",
    "password": "password"
}
```
### Create new role
```POST: /role/save```

body: JSON
```json
{
    "name": "ROLE_ADMIN",
}
```
### Add role to user
```POST: /role/addToUser```

body: JSON
```json
{
    "username": "test@mail.com",
    "rolename": "ROLE_ADMIN",
}
```

### User login returns JWT token
```POST: /api/login```

header: x-www-form-urlencoded
```json
KEY             VALUE
________        _____________

username        test@mail.com
password        password
```

Returns:

```json
{
    "access_token": "pbkBtcWlsLmNvbSIsInJvbGVzIjpbIlJPTEVfQURNSU4i.eyJzdpbkBtcWlsLmNvbSIsInJvbGVzIjpbIlJPTEVfQURNSU4iInJvbGVzIjpbIlJPTEVfQURNSU4i2xvY2FsaG9zdDo4MDgwL2FwaS9sb2dpbiIsImpbkBtcWlsLmNvbSIsInJvbGVzIjpbIlJPTEVfpbkBtcWlsLmNvbSIsInJvbGVzIjpbIlJPTEVfQURNSU4igFyieDP8",
    "refresh_token": "pbkBtcWlsLmNvbSIsInJvbGVzIjpbIlJPTEVfQURNSU4i.eyJzdpbkBtcWlsLmNvbSIsInJvbGVzIjpbIlJPTEVfQURNSU4iInJvbGVzIjpbIlJPTEVfQURNSU4i2xvY2FsaG9zdDo4MDgwL2FwaS9sb2dpbiIsImpbkBtcWlsLmNvbSIsInJvbGVzIjpbIlJPTEV",
    "roles": "ROLE_ADMIN",
    "username": "test@mail.com"
}
```

### Refresh user token
```GET: /token/refresh```

header: Authorization

```json
KEY                 VALUE
________            __________________________
Authorization       "Bearer refresh_token_key"
```
## Food
### Return all food items
```GET: /food```
```json
[
    [
    {
        "id": 4,
        "name": "Cangreburger",
        "type": "burger",
        "ingredients": "Carne de cangrejo",
        "vegan": false,
        "alergies": "cangrejo",
        "price": 15.0,
        "img": "assets/img/product/burger-cangreburger.png"
    },
    {
        "id": 5,
        "name": "Eggburger",
        "type": "burger",
        "ingredients": "egg",
        "vegan": false,
        "alergies": "Egg",
        "price": 10.0,
        "img": "assets/img/product/burger-eggburger.png"
    }
]
```
### Return food by id
```GET: /food/{id}```
```json
[
    [
    {
        "id": 4,
        "name": "Cangreburger",
        "type": "burger",
        "ingredients": "Carne de cangrejo",
        "vegan": false,
        "alergies": "cangrejo",
        "price": 15.0,
        "img": "assets/img/product/burger-cangreburger.png"
    }
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