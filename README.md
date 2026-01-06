# ECApp

## 概要
Spring Boot + Gradle で作成したECサイトのバックエンドAPI。

## 技術スタック
- Java 21
- Spring Boot
- Gradle
- MySQL
- JPA / Hibernate
- GitHub

## 機能一覧
- ユーザー管理
- 商品管理
- カート
- 注文管理

## API設計
### 商品API
| Method | URL                       | 説明         |
| ------ | ------------------------- | ---------- |
| GET    | /api/products             | 商品一覧取得     |
| GET    | /api/products/{productId} | 商品詳細取得     |
| POST   | /api/products             | 商品登録       |
| PUT    | /api/products/{productId} | 商品更新（全更新）  |
| PATCH  | /api/products/{productId} | 商品更新（部分更新） |
| DELETE | /api/products/{productId} | 商品削除       |

### ユーザーAPI
| Method | URL                 | 説明           |
| ------ | ------------------- | ------------ |
| POST   | /api/users          | ユーザー新規登録     |
| GET    | /api/users/{userId} | ユーザー情報取得     |
| PUT    | /api/users/{userId} | ユーザー更新（全更新）  |
| PATCH  | /api/users/{userId} | ユーザー更新（部分更新） |
| DELETE | /api/users/{userId} | ユーザー削除       |
| POST   | /api/login          | ログイン         |

### カートAPI
| Method | URL                   | 説明      |
| ------ | --------------------- | ------- |
| GET    | /api/cart             | カート一覧取得 |
| POST   | /api/cart/{productId} | カート商品追加 |
| PATCH  | /api/cart/{productId} | カート数量変更 |
| DELETE | /api/cart/{productId} | カート商品削除 |

### 注文API
| Method | URL                          | 説明        |
| ------ | ---------------------------- | --------- |
| POST   | /api/orders                  | 注文作成      |
| GET    | /api/orders                  | 注文一覧取得    |
| GET    | /api/orders/{orderId}        | 注文詳細取得    |
| PATCH  | /api/orders/{orderId}/status | 注文ステータス更新 |


## DB設計
### users テーブル
| カラム名 | 型 | NOT NULL | 説明 |
|-------|----|----------|----|
| id | BIGINT | ○ | PK（ユーザーID） |
| name | VARCHAR(100) | ○ | ユーザー名 |
| email | VARCHAR(255) | ○ | メールアドレス（ユニーク） |
| password | VARCHAR(255) | ○ | パスワード（ハッシュ化想定） |
| created_at | DATETIME | ○ | 作成日時 |
| updated_at | DATETIME | ○ | 更新日時 |

### products テーブル
| カラム名 | 型 | NOT NULL | 説明 |
|-------|----|----------|----|
| id | BIGINT | ○ | PK（商品ID） |
| title | VARCHAR(255) | ○ | 商品名 |
| price | INT | ○ | 価格 |
| stock | INT | ○ | 在庫数 |
| created_at | DATETIME | ○ | 作成日時 |
| updated_at | DATETIME | ○ | 更新日時 |

### carts テーブル
| カラム名 | 型 | NOT NULL | 説明 |
|-------|----|----------|----|
| id | BIGINT | ○ | PK（カートID） |
| user_id | BIGINT | ○ | ユーザーID（users.id） |
| created_at | DATETIME | ○ | 作成日時 |
| updated_at | DATETIME | ○ | 更新日時 |

### cart_items テーブル
| カラム名 | 型 | NOT NULL | 説明 |
|-------|----|----------|----|
| id | BIGINT | ○ | PK（カート商品ID） |
| cart_id | BIGINT | ○ | カートID（carts.id） |
| product_id | BIGINT | ○ | 商品ID（products.id） |
| amount | INT | ○ | 数量 |
| price | INT | ○ | 価格（カート追加時点の価格） |
| created_at | DATETIME | ○ | 作成日時 |
| updated_at | DATETIME | ○ | 更新日時 |

### orders テーブル
| カラム名 | 型 | NOT NULL | 説明 |
|-------|----|----------|----|
| id | BIGINT | ○ | PK（注文ID） |
| order_number | VARCHAR(50) | ○ | 注文番号（ユニーク） |
| user_id | BIGINT | ○ | ユーザーID（users.id） |
| total | INT | ○ | 合計金額 |
| status | VARCHAR(20) | ○ | 注文ステータス |
| created_at | DATETIME | ○ | 注文日時 |
| updated_at | DATETIME | ○ | 更新日時 |

### order_items テーブル
| カラム名 | 型 | NOT NULL | 説明 |
|-------|----|----------|----|
| id | BIGINT | ○ | PK（注文商品ID） |
| order_id | BIGINT | ○ | 注文ID（orders.id） |
| product_id | BIGINT | ○ | 商品ID（products.id） |
| product_title | VARCHAR(255) | ○ | 商品名（注文時点の名称） |
| amount | INT | ○ | 数量 |
| price | INT | ○ | 単価 |
| sub_total | INT | ○ | 小計（price × amount） |

### order_address テーブル
| カラム名 | 型 | NOT NULL | 説明 |
|-------|----|----------|----|
| id | BIGINT | ○ | PK（配送先ID） |
| order_id | BIGINT | ○ | 注文ID（orders.id） |
| postal_code | VARCHAR(20) | ○ | 郵便番号 |
| prefecture | VARCHAR(50) | ○ | 都道府県 |
| address1 | VARCHAR(255) | ○ | 住所 |
| address2 | VARCHAR(255) | | 建物名・部屋番号（任意） |
| created_at | DATETIME | ○ | 作成日時 |
| updated_at | DATETIME | ○ | 更新日時 |


## ER図
![EC Diagram](docs/ec-diagram.png)

## 起動方法
```bash
./gradlew bootRun
