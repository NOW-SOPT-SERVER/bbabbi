# 1️⃣ 어떤 API 인가요?
### Member의 id로 정보를 받아오는 GET API

# 2️⃣ Request

## Path Parameter

| Key | Type | Description |
|-----|------|-------------|
|memberId| Long | Memeber의 Id |

| HTTP Method | End Point(URL)              |
|-------------|-----------------------------|
| GET         | `/api/v1/member/{memberId}` |

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
{
  "name" : "Chaeyoung Moon",
  "part" : "SERVER",
  "age" : 24
}
```