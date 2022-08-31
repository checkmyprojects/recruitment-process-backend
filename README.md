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

### :space_invader: Tech Stack
<p align="left">
<a href="https://www.java.com" style="margin-right: 10px" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/><span>Java</span> </a>
<a href="https://spring.io/" style="margin-right: 10px" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> <span>Spring Boot</span></a>
<a href="#" target="_blank" style="margin-right: 10px" rel="noreferrer"> <img src="https://huongdanjava.com/wp-content/uploads/2021/05/spring-security-logo.png" alt="java" width="90" height="40"/><span>Spring Security</span> </a>

<a href="https://jwt.io/" style="margin-right: 10px" target="_blank" rel="noreferrer"> <img src="https://jwt.io/img/pic_logo.svg" alt="mysql" width="40" height="40"/> <span>JWT</span></a>
<a href="https://www.mysql.com/" style="margin-right: 10px" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="40" height="40"/> <span>MySQL</span></a>
<a href="#" style="margin-right: 10px" target="_blank" rel="noreferrer"> <img src="https://cleventy.com/wp-content/uploads/2020/05/javamail.png" alt="javax.mail" width="40" height="40"/><span>javax.mail</span> </a>
<a href="#" style="margin-right: 10px" target="_blank" rel="noreferrer"> <img src="https://github.com/mockito/mockito.github.io/raw/master/img/logo%402x.png" alt="mockito" width="90" height="40"/><span>mockito</span> </a>
<a href="#" style="margin-right: 10px" target="_blank" rel="noreferrer"> <img src="https://i0.wp.com/www.clubdetecnologia.net/wp-content/uploads/2018/10/junit5-logo.png?fit=512%2C512&ssl=1" alt="junit5" width="40" height="40"/><span>junit5</span> </a>


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


---

# API Documentation

### Base Path: /api

<details>
  <summary>Return a list of users with roles</summary>

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
</details>

<details>
  <summary>Return a user by {id} with roles and orders</summary>

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
]
```
</details>

<details>
<summary>Delete user by {id}</summary>

```DELETE: /admin/delete/44```
```json
{ void }
```
</details>

<details>

<summary>Return the authed user username</summary>

```GET: /admin/users/whoami```
```json
"test@mail.com"
```
</details>

<details>
<summary>Create new user</summary>

```POST: /auth/signup```
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
</details>

<details>
<summary>User login returns JWT token</summary>

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

</details>

<details>
<summary>List All Candidates</summary>

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
</details>

<details>
<summary>New Candidate</summary>

```POST: /candidate/new```
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
</details>

<details>
<summary>List Selection Process</summary>

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
</details>

<details>
<summary>Create Selection Process</summary>

```POST: /selection/new?creatorid=14```

```json
[
  {
    "start_date": "2022-11-15",
    "name": "Java Spring Boot",
    "description": "Senior Java Team manager",
    "requirements": "Java, Spring Boot",
    "location": "Sevilla",
    "sector": "Health",
    "status": "Active",
    "priority": "High",
    "project_id": 123123123,
    "remote": false
  }
]
```
</details>

<details>
<summary>Delete Selection Process by {id}</summary>

```DELETE: selection/delete/{id}```
```json
{
  "start_date": "2022-09-12",
  "name": "Java Spring Boot",
  "description": "Senior Java Team manager",
  "requirements": "Java, Spring Boot",
  "location": "Sevilla",
  "sector": "Health",
  "status": "Active",
  "priority": "High",
  "project_id": 123123123,
  "remote": false
}
```
Returns:
```json
{ void }
```
</details>

<details>
<summary>List All Interviews</summary>

```json

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
"id": 35,
"candidate": {
"id": 36,
"name": "Berget",
"surname": "Cakebread",
"email": "bcakebreadz@yahoo.co.jp",
"skills": "Tampflex",
"studies": "Structural Engineer",
"location": "Hekou",
"experience": 12,
"hired": true,
"state": "",
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
"interview_date": "2022-08-18 / 12:19:37",
"creation_date": "2022-08-18 / 12:19:39"
},
{
"id": 18,
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
"interview_date": "2022-08-29 / 15:15:36",
"creation_date": "2022-08-14 / 22:17:45"
},


```

</details>

<details>
<summary>Find interview by ID</summary>

```GET: /selection/list?30```
```json
[
  {
    "id": 30,
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
    "interview_date": "2022-08-18 / 11:44:40",
    "creation_date": "2022-08-18 / 11:44:42"
  },
]
```
</details>

<details>
<summary>Create Interview</summary>

```POST: /interview/new```
```json
[
  {
    "candidateId": 5,
    "interviewerId": 1,
    "selectionId": 5,
    "date": "2022-01-01T22:22:22",
    "status": "Activo",
    "feedback": ""

  }
]
```
Returns:
```json
{
  "id": 40,
  "candidate": {
    "id": 5,
    "name": "Benedetta",
    "surname": "Scurry",
    "email": "bscurry4@istockphoto.com",
    "skills": "Keylex",
    "studies": "Senior Cost Accountant",
    "location": "Mevo horon",
    "experience": 24,
    "hired": true,
    "state": "",
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
  "selection": {
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
    "remote": false
  },
  "status": "Activo",
  "feedback": "",
  "interview_date": "2022-01-01 / 22:22:22",
  "creation_date": "2022-08-31 / 08:59:45"
}
```

</details>

<details>
<summary>Delete Interview by {id}</summary>

```DELETE: /interview/delete/40```

```json
{ void }
```

</details>


### :memo: Lessons Learned:


---


### :spiral_notepad: License

This project is licensed under the **Entiteam** License - see the file [LICENSE.md](LICENSE.md) for details.

### :gift: Thanks

* Tell others about this project 📢
* Invite someone from the team to a beer 🍺 or a coffee ☕.
* Give thanks publicly 🤓.
* etc.



---