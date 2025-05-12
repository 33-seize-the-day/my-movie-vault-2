# My Movie Vault 專案概要

自學 Java 期間所完成的練習專案，整合 CLI 與 Spring Boot Web 技術，打造一套簡易電影收藏管理系統。  
透過 SQLite 儲存電影資料，並設計基本的資料操作邏輯，未來將擴充 RESTful API 與前端整合能力。

## 一、使用技術

- Java 17
- Spring Boot 3.4.5
- Spring Data JPA / Hibernate
- SQLite（本機資料庫）
- Maven Wrapper
- Git / IntelliJ IDEA

## 二、專案功能

### 1. CLI 操作
- 新增電影資料（輸入電影名稱、類型）
- 查看電影清單
- 離開程式

### 2. Web 控制
- 啟動內建 Tomcat 伺服器
- RESTful API 功能預計擴充中

## 三、系統架構概觀

```
CLI ──> JDBC ──> SQLite
        ↓
     Spring Boot ──> Web Controller (`/`)
```


## 四、自我反思與未來計畫

本專案為我轉職資訊領域的第一個整合性練習，建構從資料存取到 Web 控制的初步開發流程。實作過程中學習Git 操作、CLI 互動邏輯與 SQLite 整合方式，並解決 Hibernate 驅動連線等常見錯誤。
後續規劃將補上完整的 RESTful API 串接功能，並搭配前端框架 Vue 或 Angular，打造完整前後端分離的作品集。
