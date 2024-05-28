# 1️⃣ 어떤 API 인가요?
### 당근마켓의 '내 물건 팔기' 상품등록 API

# 2️⃣ Request
| HTTP Method | End Point(URL)    |
|-------------|-------------------|
| POST        | `/api/v1/product` |

## Request Header

## Request Body

| 이름       | 타입     | Description   |
|----------|--------|---------------|
| title    | String | 등록하려는 상품의 상품명 |
| price    | int    | 상품의 가격        |
| note     | String | 상품에 대한 설명     |
| spot     | String | 거래 장소         |

```json
{
  "title" : "운영체제 교재",
  "price" : 10000,
  "note" : "새 책입니다",
  "spot" : "충무로역"
}
```

# 3️⃣ Response

### ✨ Response Body

| status | 201 Created |
|--------|-------------|