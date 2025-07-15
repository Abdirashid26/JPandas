# JPandas — A Pandas-Style DataFrame Library for Java

> 📊 A lightweight, high-performance Java library that brings the power of Python's Pandas to the Java ecosystem.

JPandas (short for **Java Pandas**) lets developers work with tabular data using an intuitive API inspired by Python’s DataFrame style. It’s ideal for data filtering, aggregation, transformation, and CSV I/O — all in pure Java.

---

## ✨ Features

- 🧮 **DataFrame API** — familiar and chainable
- 📂 **CSV Reader/Writer** — load and save datasets easily
- 🔍 **filter**, **select**, **groupBy**, and **count** operations
- 📦 Lightweight, fast, and dependency-free
- ✅ Works on Java 17+ and Java 21+

---

## 🚀 Quick Start

### 1. Add Maven Dependency

If you're using **GitHub Packages**, add this to your `pom.xml`:

```xml
<repositories>
  <repository>
    <id>github</id>
    <url>https://maven.pkg.github.com/Abdirashid26/JPandas</url>
  </repository>
</repositories>

<dependency>
  <groupId>org.faisaldev</groupId>
  <artifactId>dataframe</artifactId>
  <version>0.0.1</version>
</dependency>
```

> ⚠️ Requires a GitHub personal access token in your `~/.m2/settings.xml` for authentication.

---

### 2. Basic Example

```java
import core.DataFrame;
import io.CsvReader;

public class Main {
    public static void main(String[] args) {

        int no_of_rows = 10;
        DataFrame df = new CsvReader().read("data/students.csv");

        df.show(no_of_rows); // Print first no_of_rows or if the maximum exisitng bellow it

        DataFrame filtered = df.filter(row -> (int) row.get("age") >= 12);
        filtered.show(no_of_rows);

        DataFrame selected = df.select("name", "city");
        selected.show(no_of_rows);

        DataFrame grouped = df.groupBy("city").count();
        grouped.show(no_of_rows);
    }
}
```

---

## 📁 Example CSV

```csv
name,age,city
Alice,10,Nairobi
Brian,12,Mombasa
Claire,11,Kisumu
```

---

## 🧠 Why JPandas?

While Java is a strong backend language, it lacks a modern, ergonomic data manipulation library like Python’s Pandas. **JPandas** fills that gap by offering:

- Familiar syntax for developers with Python or SQL background
- Type-safe operations with Java’s performance
- No external dependencies or reflection

---

## 🔧 Build From Source

```bash
git clone https://github.com/Abdirashid26/JPandas.git
cd JPandas
mvn clean install
```

---

## 🧩 Upcoming Features

- Excel file support (`.xlsx`)
- JSON and SQL import/export
- Pivot tables and joins
- Data visualization hooks (via JavaFX or external libraries)

---

## 📜 License

MIT License. Use freely for commercial and personal projects.

---

## 💬 Feedback & Contributions

We’d love your feedback, feature requests, and contributions. Feel free to:
- ⭐ Star the repo
- 🐛 Report issues
- 🧑‍💻 Submit pull requests

---

## 🔍 Keywords (for SEO)

`java dataframe`, `pandas java`, `jpandas`, `dataframe library java`, `csv java`, `data wrangling java`, `maven dataframe`, `open source java pandas`, `java tabular data`

---

Made with ❤️ by [Abdirashid](https://github.com/Abdirashid26)
