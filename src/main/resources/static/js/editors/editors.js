'use strict';

window.addEventListener('DOMContentLoaded', () => {
    const elem = document.querySelector('main');
    const modalTitle = document.querySelector('.modal-title');
    const hint = document.querySelector('#modal-hint');
    const container = document.querySelector('.modal-body-buttons');
    const observer = new MutationObserver((mutations) => {
        mutations.forEach((mutation) => {
            for(let node of mutation.addedNodes) {
                if (!(node instanceof HTMLElement)) continue;

                if (node.matches('div.card')){
                    const buttonEditor = node.querySelector('button[button-editor]');
                    if (!buttonEditor.hasAttribute('has-listener')) {
                        buttonEditor.setAttribute('data-bs-toggle', 'modal');
                        buttonEditor.setAttribute('data-bs-target', '#main-modal');
                        buttonEditor.addEventListener('click', () => {
                            const titleText = getTitleEditText(node);
                            initializeFormContainer(container, modalTitle, titleText, hint);
                            const form = getEditForm(node);
                            container.textContent = ``;
                            container.append(form);
                        });
                        buttonEditor.setAttribute('has-listener', '');
                    }
                }
            }
        });
    });
    const config = {childList: true, subtree: true};
    observer.observe(elem, config);
});