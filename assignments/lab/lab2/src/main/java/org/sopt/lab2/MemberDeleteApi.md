# 1️⃣ 어떤 API 인가요?
### Member 객체를 지우는 DELETE API

# 2️⃣ Request

## Path Parameter

| Key | Type | Description |
|-----|------|-------------|
|memberId| Long | Memeber의 Id |

| HTTP Method | End Point(URL)              |
|-------------|-----------------------------|
| DELETE      | `/api/v1/member/{memberId}` |

## Request Body

| status | 204 No Content |
|--------|----------------|


---

# 3️⃣ Response

### ✨ Response Body

| status | 상태 코드 |
| --- | --- |
| message | String |
|  |  |

Response Body를 JSON 형태로 적어주세요.

```json
{
}
```