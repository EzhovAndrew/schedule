'use strict';

window.addEventListener('DOMContentLoaded', async () => {
    const elem = document.querySelector('main');
    const observer = new MutationObserver(async (mutations) => {
        mutations.forEach((mutation) => {
            for(let node of mutation.addedNodes) {
                if (!(node instanceof HTMLElement)) continue;

                if (node.matches('div.card')){
                    const buttonDeleter = node.querySelector('button[button-deleter]');
                    if (!buttonDeleter.hasAttribute('has-listener')) {
                        buttonDeleter.addEventListener('click', async () => {
                            const resource = getDeleteResource(node);
                            await fetch(resource, {method: 'DELETE'});
                            node.remove();
                            redisplayCards();
                        });
                        buttonDeleter.setAttribute('has-listener', '');
                    }
                }
            }
        });
    });
    const config = {childList: true, subtree: true};
    observer.observe(elem, config);
});