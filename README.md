# mstlib

[![Maven Central](https://img.shields.io/maven-central/v/de.scplabs/mstlib.svg)](https://search.maven.org/artifact/de.scplabs/mstlib)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

**mstlib** is a lightweight Java library for building and sending [Microsoft Teams](https://learn.microsoft.com/en-us/microsoftteams/platform/webhooks-and-connectors/how-to/connectors-using) Incoming Webhook Adaptive Cards with ease.

This library simplifies the process of creating rich messages using Adaptive Cards and posting them to Teams channels via incoming webhooks.

---

## 🚀 Features

- Create Adaptive Cards in Java with a fluent API
- Post cards directly to Microsoft Teams via Incoming Webhooks
- Supports text blocks, images, facts and more

---

## 📦 Installation

Add the following to your `pom.xml` (Maven):

```xml
<dependency>
  <groupId>de.scplabs</groupId>
  <artifactId>mstlib</artifactId>
  <version>1.0.0</version>
</dependency>
```

---

## 🔧 Usage

### 1. Create a Webhook URL

Follow [Microsoft's documentation](https://learn.microsoft.com/en-us/microsoftteams/platform/webhooks-and-connectors/how-to/add-incoming-webhook) to create an Incoming Webhook for your Teams channel.

### 2. Build and Send a Card

```java
import de.scplabs.mstlib.IncomingWebhookBuilder;
import de.scplabs.mstlib.Webhook;

public class Main {
    public static void main(String[] args) {
        IncomingWebhookBuilder builder = new IncomingWebhookBuilder("WEBHOOK_URL");
        Webhook wh = builder
                .addTextBlock("Hello Teams!").getStyle(FontStyle.BOLD).prev()
                .addTextBlock("This is a sample Adaptive Card.").prev()
                .build();

        wh.execute();
    }
}
```

---

## 🧩 Components Supported
### Card Elements
- ✅ TextBlock
- ✅ Image
- ✅ Media
- ✅ MediaSource
- ✅ CaptionSource
- ✅ RichTextBlock
- ✅ TextRun

### Containers
- ✅ Container
- ✅ ColumnSet
- ✅ Column
- ✅ FactSet
- ✅ Fact
- ✅ ImageSet
- ✅ Table
- ✅ TableCell

### Types
- ✅ BackgroundImage

---

## 🛠️ Building Locally

```bash
git clone https://github.com/Flo0205/mstlib.git
cd mstlib
mvn clean install
```

---

## 📄 License

MIT License. See [LICENSE](./LICENSE) for details.

---

## 🤝 Contributing

Pull requests are welcome!  
If you’d like to improve or extend the library, please open an issue or PR.

---



Created by [Florian Keil](https://github.com/Flo0205)
