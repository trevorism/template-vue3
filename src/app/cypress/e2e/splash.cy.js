describe('template spec', () => {
    it('passes', () => {
        cy.visit('https://example.cypress.io')
        cy.title().should('equal', 'Cypress.io: Kitchen Sink')
    })
})