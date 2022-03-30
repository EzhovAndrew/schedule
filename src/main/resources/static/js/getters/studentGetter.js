'use strict';

window.addEventListener('DOMContentLoaded', async () => {
    const resource = 'http://localhost:8080/students/get/';
    const elem = document.querySelector('.modal-body-buttons');
    const container = document.querySelector('#modal-hint');
    const observer = new MutationObserver(async (mutations) => {
        mutations.forEach((mutation) => {
            for(let node of mutation.addedNodes) {
                if (!(node instanceof HTMLElement)) continue;
                
                if (node.matches('form#FormToGetStudents')){
                    node.addEventListener('submit', async(ev) => {
                        ev.preventDefault();
                        const data = new FormData(node);
                        const object = {};
                        data.forEach((value, key) => {
                            object[key] = value;
                        });
                        const responseData = await getData(resource, container, object, elem);
                        if (responseData.length === 0) {
                            document.querySelector('div.container-md').textContent = 'По вашему запросу ничего не нашлось.'
                        }
                        responseData.forEach((elem, index) => {
                            const elemCard = getStudentCard(elem);
                            displayCard(elemCard, index);
                        });
                        container.textContent = 'Данные успешно загружены!'
                    });
                }
            }
        });
    });
    const config = {childList: true, subtree: true};
    observer.observe(elem, config);
});