# 1️⃣ 어떤 API 인가요?
### Member 객체를 생성하는 POST API

# 2️⃣ Request
| HTTP Method |End Point(URL)|
|-------------|---|
| POST        |`/api/v1/member`|

## Request Header

## Request Body

| 이름   | 타입     | Description               |
|------|--------|---------------------------|
| name | String | Member의 이름                |
| part | String | Member의 파트(Member가 속한 파트) |
| age  | int    | Member의 나이                |

```json
{
  "name" : "Chaeyoung Moon",
  "part" : "SERVER",
  "age" : 24
}
```

---

# 3️⃣ Response

### ✨ Response Body

| status | 201 Created |
|--------|-------------|

Response Body를 JSON 형태로 적어주세요.

```json
{
  
}
```