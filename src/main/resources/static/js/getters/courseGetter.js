'use strict';

window.addEventListener('DOMContentLoaded', async () => {
    const resource = 'http://localhost:8080/courses/get/';
    const elem = document.querySelector('.modal-body-buttons');
    const container = document.querySelector('#modal-hint');
    const observer = new MutationObserver(async (mutations) => {
        mutations.forEach((mutation) => {
            for(let node of mutation.addedNodes) {
                if (!(node instanceof HTMLElement)) continue;
                
                if (node.matches('button#Get-btn-courses')){
                    node.addEventListener('click', async () => {
                        const data = await getData(resource, container, {}, elem);
                        data.forEach((elem, index) => {
                            const elemCard = getCourseCard(elem);
                            displayCard(elemCard, index);
                        });
                        container.textContent = 'Данные успешно загружены!';
                        elem.classList.remove('mid-height');
                    });
                }
            }
        });
    });
    const config = {childList: true, subtree: true};
    observer.observe(elem, config);
});