import {html, render} from "../deps/lit-html.js";

class CA extends HTMLElement {
    onError = false;
    errorMessage = "";

    constructor() {
        super();
        this.onError = false;
    }

    connectedCallback() {
        console.log("Base64 Component mounted...")
        const template = html`

            <label for="pet-select">Scegli azione: </label>
            <select name="algorithms" id="algorithm-select">
                <option value="">--Please choose an option--</option>
                <option value="enc">Encode</option>
                <option value="dec">Decode</option>
            </select>

            <div class="field">
                <label class="label">Message</label>
                <div class="control">
                    <textarea class="textarea" placeholder="Textarea" name="plainText" id="plainText"></textarea>
                </div>
            </div>

            <div class="field">
                <label class="label">Hashed</label>
                <div class="control">
                    <textarea class="textarea" placeholder="Hashed" name="hashedText" id="hashedText"
                              disabled></textarea>
                </div>
            </div>


            <div class="field is-grouped">
                <div class="control">
                    <button class="button is-link" id="submit" @click="${this.handleSubmit}">Submit</button>
                </div>
                <div class="control">
                    <button class="button is-link is-light" @click="${this.handleCancel}">Cancel</button>
                </div>
            </div>

            <div class="notification is-danger" id="error-msg" style="visibility: hidden">
                <button class="delete"></button>
                this.errorMessage
            </div>

        `;
        render(template, this);
    }

    handleCancel() {
        document.getElementById('plainText').value = "";
        document.getElementById('hashedText').value = "";
        document.getElementById("hashedText").disabled = true;
    }

    async handleSubmit() {
        const plainText = document.getElementById('plainText').value;
        const selectedAlgorithm = document.getElementById('algorithm-select').value;

        if (selectedAlgorithm === "" || selectedAlgorithm === "undefined") {
            console.log("Unable to send request with empty algorithm chosen");
            this.errorMessage = "Unable to send request with empty algorithm chosen";
            document.getElementById('error-msg').style.visibility = 'visible';
            return;
        }
        if (plainText === "" || plainText === "undefined") {
            console.log("Unable to send request with empty message");
            this.errorMessage = "Unable to send request with empty message";
            document.getElementById('error-msg').style.visibility = 'visible';
            return;
        }

        const payload = {
            plainText: plainText,
            algorithm: selectedAlgorithm
        }
        const options = {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(payload)
        }

        const response = await fetch('http://localhost:8080/api/v1/hashing', options);
        if (response.status !== 200) {
            console.log("Error on hashing function");
            this.errorMessage = "Unable to receive response, server respond with status !== 200";
            document.getElementById('error-msg').style.visibility = 'visible';
            return;
        }
        const body = await response.json();
        document.getElementById("hashedText").value = body.hashedText;
        document.getElementById("hashedText").disabled = false;
    }
}

customElements.define('c-ca', CA);