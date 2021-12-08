import {html, render} from "../deps/lit-html.js";

class Footer extends HTMLElement {
    hostname = "";

    connectedCallback() {
        this.getHostname();
        console.log("Footer Component mounted...")
        const template = html`
            <footer class="footer">
                <div class="content has-text-centered">
                    <p>
                        <strong>Crypto Quarkus</strong> by <a href="https://aldolushkja.it">Aldo Lushkja</a>. The source
                        code is licensed
                        <a href="http://opensource.org/licenses/mit-license.php">MIT</a>. The website content
                        is licensed <a href="http://creativecommons.org/licenses/by-nc-sa/4.0/">CC BY NC SA 4.0</a>.
                    </p>
                    <p>
                        <strong>Server by: </strong>${this.hostname ? this.hostname : "localhost"}
                    </p>
                </div>
            </footer>
        `;
        render(template, this);
    }


    async getHostname() {
        const response = await fetch('http://localhost:8080/ping');
        const json = await response.json();
        this.hostname = json.hostname;
        console.log(this.hostname);
    }
}

customElements.define("c-footer", Footer);