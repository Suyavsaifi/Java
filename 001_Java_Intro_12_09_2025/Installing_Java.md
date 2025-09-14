### 💻 Installing Java on Windows

1.  **Download the JDK:** Go to the official Oracle website or another reputable source like Eclipse Adoptium and download the Windows x64 Installer (.exe file) for the latest Java Development Kit (JDK) version.
2.  **Run the Installer:** Double-click the downloaded .exe file to start the installation wizard. Follow the on-screen prompts.
3.  **Set Environment Variables:** After installation, it's recommended to set the `JAVA_HOME` environment variable and add Java to your `PATH`. Many installers do this automatically, but if not, you'll need to do it manually:
    * Find the Java installation path (e.g., `C:\Program Files\Java\jdk-<version>`).
    * Search for "Environment Variables" in the Windows Start menu and open the dialog.
    * Under "System variables," click "New" to create `JAVA_HOME` and set its value to your JDK installation path.
    * Select the `Path` variable and click "Edit." Add `%JAVA_HOME%\bin` to the list.
4.  **Verify the Installation:** Open Command Prompt or PowerShell and type `java -version`. You should see the installed Java version information.

-----

### 🐧 Installing Java on Linux (Ubuntu)

1.  **Use a Package Manager:** The easiest way to install Java on a Debian-based Linux distribution like Ubuntu is by using the `apt` package manager.
2.  **Install the Default JDK:** Open a terminal and run the following command to install the latest Long-Term Support (LTS) version of OpenJDK:
    ```bash
    sudo apt install default-jdk
    ```
3.  **Set JAVA\_HOME (Optional but Recommended):** To set the `JAVA_HOME` environment variable, edit your shell configuration file (e.g., `~/.bashrc` or `~/.zshrc`) and add the following lines:
    ```bash
    export JAVA_HOME=/usr/lib/jvm/default-java
    export PATH=$JAVA_HOME/bin:$PATH
    ```
    Then, apply the changes by running `source ~/.bashrc` (or `source ~/.zshrc`).
4.  **Verify the Installation:** In the terminal, run `java -version` to confirm that Java is installed and the version is correct.

-----

### 🍎 Installing Java on macOS

The installation process for macOS varies slightly between Intel-based Macs and Apple Silicon (M1/M2/M3) Macs, as they use different architectures.

#### **For Intel-based Macs:**

1.  **Download the JDK:** Go to the official Oracle website and download the JDK for macOS x64 systems. It will be a `.dmg` file.
2.  **Run the Installer:** Double-click the `.dmg` file and then double-click the installer package (`.pkg`) to start the installation wizard. Follow the prompts to complete the process.
3.  **Verify the Installation:** Open a terminal and type `java -version` to confirm the installation.

#### **For Apple Silicon (M1/M2/M3) Macs:**

1.  **Download the JDK:** Download the macOS ARM64 DMG Installer from the official Oracle website.
2.  **Run the Installer:** Double-click the downloaded `.dmg` file and follow the on-screen instructions.
3.  **Set JAVA\_HOME:** Apple Silicon Macs may require setting the `JAVA_HOME` path. In your terminal, use the following command to find the correct path:
    ```bash
    /usr/libexec/java_home
    ```
    Then, add the following to your shell configuration file (e.g., `~/.zshrc` for zsh or `~/.bash_profile` for bash):
    ```bash
    export JAVA_HOME=$(/usr/libexec/java_home)
    ```
    Apply the changes by running `source ~/.zshrc` (or `source ~/.bash_profile`).
4.  **Verify the Installation:** In the terminal, run `java -version` to ensure Java is installed.