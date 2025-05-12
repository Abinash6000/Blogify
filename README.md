# 📖 Simple Blog App

A minimal, elegant **Blog App** built with **Jetpack Compose**. It fetches blogs from an API using **Ktor**, supports **pagination**, and displays them with smooth image loading via **Coil**. Clicking on a blog opens it in a beautiful in-app **WebView**. That's it—no fluff, no profile page, no blog posting. Just good old reading.

---

## ✨ Features

- 🧱 Built with Jetpack Compose (declarative UI)
- 🌐 Fetch blogs from a remote API using Ktor client
- 📄 Open blog posts in an in-app WebView
- 🖼 Image loading using Coil
- 🔄 Pagination support for infinite scrolling
- 🚫 No user authentication, profile, add/delete blogs — just scroll and read!

---

## 📸 Screenshots

| Home Screen (Blog List) | Blog Detail (WebView) |
|--------------------------|------------------------|
| <img src="https://github.com/user-attachments/assets/7f531449-2b41-4b21-b6b9-582a4fc59672" alt="Image description" width="300"/> | <img src="https://github.com/user-attachments/assets/b887a4c5-fcd5-43f6-94bb-e7c527a09061" alt="Image description" width="300"/> |

---

## 🧩 Tech Stack

- **Jetpack Compose** – For UI
- **Ktor Client** – For HTTP requests
- **Coil** – For loading images
- **WebView** – To render blog content
- **Kotlin Coroutines** – For async data fetching

---

## 📦 Folder Structure

📂 simple-blog-app  
├── 📁 ui            -> Jetpack Compose UI components  
├── 📁 network       -> Ktor client setup and API services  
├── 📁 model         -> Data models  
├── 📁 viewmodel     -> ViewModel and pagination logic  
├── 📁 utils         -> Misc utilities (e.g., constants, extensions)  

## 📱 App Icon
<img src="https://github.com/user-attachments/assets/916073b5-e178-48c8-ba18-54d4db4038af" alt="Image description" width="100"/>
