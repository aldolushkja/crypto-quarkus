import {html, render} from "../deps/lit-html.js";

class Navbar extends HTMLElement {

    connectedCallback() {
        console.log("Navbar Component mounted...")
        const template = html`
            <nav class="navbar is-transparent">
                <div class="navbar-brand">
                    <a class="navbar-item" href="/">
                        <img src="https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.MP04PHWxi9bSr9FnRwlT7gHaFJ%26pid%3DApi&f=1"
                             alt="Bulma: a modern CSS framework based on Flexbox"
                             width="auto" height="auto">
                    </a>
                    <div class="navbar-burger" data-target="navbarExampleTransparentExample">
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                </div>

                <div id="navbarExampleTransparentExample" class="navbar-menu">
                    <div class="navbar-start">
                        <a class="navbar-item" href="/hashing">
                            Hashing
                        </a>
                        <a class="navbar-item" href="/certificates">
                            Certificates
                        </a>
                        <a class="navbar-item" href="/criptography">
                            Criptography
                        </a>
                        <a class="navbar-item" href="/ds">
                            Digital Signatures
                        </a>

                        <a class="navbar-item" href="/ca">
                            Certificate Authority (CA)
                        </a>
                    </div>
                    
                </div>
            </nav>
        `;
        render(template, this);
    }
}

customElements.define("c-navbar", Navbar);