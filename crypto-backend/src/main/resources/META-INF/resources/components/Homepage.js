import {html, render} from "../deps/lit-html.js";


class Homepage extends HTMLElement {

    constructor() {
        super();
    }

    connectedCallback() {
        console.log("Home Component mounted...")
        const template = html`
            <div>
                <p>This is the home page</p>
            </div>
        `;
        render(template, this);
    }

}

customElements.define('c-home', Homepage);