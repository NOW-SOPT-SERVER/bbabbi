# 1️⃣ 어떤 API 인가요?

### 모든 멤버의 정보를 <span style="color:orangered">List</span>로 받아오는 GET API

# 2️⃣ Request

| HTTP Method | End Point(URL)             |
|-------------|----------------------------|
| GET         | `/api/v1/member/allmember` |

## Path Parameter

## Request Header

## Request Body

---

# 3️⃣ Response

### ✨ Response Body

| status | 200 OK |
|--------|--------|

| 이름   | 타입     | Description               |
|------|--------|---------------------------|
| name | String | Member의 이름                |
| part | String | Member의 파트(Member가 속한 파트) |
| age  | int    | Member의 나이                |

Response Body를 JSON 형태로 적어주세요.

```json
[
  {
    "name": "Chaeyoung Moon",
    "part": "SERVER",
    "age": 24
  },
  {
    "name": "Gildong Hong",
    "part": "IOS",
    "age": 15
  },
  {
    "name": "H S KIM",
    "part": "PLAN",
    "age": 26
  }
]
```